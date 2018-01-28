package aus.hack.hedna.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import com.fasterxml.jackson.core.type.TypeReference;

import aus.hack.hedna.domain.Property;
import aus.hack.hedna.domain.ReservationList;
import aus.hack.hedna.domain.Reservations;
import aus.hack.hedna.domain.RevenueDetails;



public class Oauth2Util {

	private static final Logger logger = LoggerFactory.getLogger(Oauth2Util.class);

	private static String CLIENT_SECRET = "70ddb616-6404-4ab8-bd17-bee588d4a68d";
	private static String CLIENT_ID = "244c2ecc-8b29-44dd-8f57-d9b5649aa751";
	private static String TOKEN_REQUEST_URL = "europewest-api-sandbox.snapshot.technology";
	private static String ACCESS_TOKEN_URI = "https://europewest-api-sandbox.snapshot.technology/oauth/token";
	private static String SNAPSHOT_HOST = "europewest-api-sandbox.snapshot.technology";
	private static String RESERVATION_URI =	"/v1/dwh/transactional/properties/05076c15-cb52-4b83-b8af-8470f85023f2/reservations";
	private static String PROPERTIES_URI =	"/v1/identity/properties";
	private static String GRANT_TYPE = "password";
	private static String USER_NAME = "paulgreen@beautifulbellhop.com";
	private static String PASSWORD = "R228ekF3";
	
	ObjectMapper mapper = new ObjectMapper();

	public ReservationList getReservations() {

		try{

			ResourceOwnerPasswordResourceDetails rOwner = new ResourceOwnerPasswordResourceDetails();
			rOwner.setAccessTokenUri(ACCESS_TOKEN_URI);
			rOwner.setClientId(CLIENT_ID);
			rOwner.setClientSecret(CLIENT_SECRET);
			rOwner.setGrantType(GRANT_TYPE);
			rOwner.setUsername(USER_NAME);
			rOwner.setPassword(PASSWORD);

			OAuth2RestTemplate oAuthRestTemplate = new OAuth2RestTemplate(rOwner);

			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.setContentType( MediaType.APPLICATION_FORM_URLENCODED );

			OAuth2AccessToken token = oAuthRestTemplate.getAccessToken();
			print("Token: " + token);

			Http request = new Http("GET",
					SNAPSHOT_HOST,
					RESERVATION_URI);
			request.addHeader("Authorization", "Bearer " + token);
			//start=2017-01-01
			//&end=2018-01-01&time_filter=created&res_status=confirmed&include_revenue_details=true&cursor=0&limit=2"
			request.addParam("start","2017-12-01");
			request.addParam("end","2018-01-30");
			request.addParam("time_filter","created");
			request.addParam("res_status", "confirmed");
			request.addParam("include_revenue_details","true");
			request.addParam("cursor","0");
			//request.addParam("limit","2");
			String contents = request.executeRequest();
			ReservationList[] rList = mapper.readValue(contents,ReservationList[].class);
			print(rList[0] +"");
			/*Double totalRevenue = rList[0].getReservations().stream()
					.filter(t -> (t.getRevenue_details()!=null))
					.mapToDouble(t -> {
									double total = 0.0; 
									for(RevenueDetails d : t.getRevenue_details()) {
										total += Double.parseDouble(d.getActual_daily_room_revenue_after_tax ());
									}
									return total;
									}
					)
					.sum();*/

			for(Reservations res : rList[0].getReservations()) {
	            		print("reservation-log " + res);
	        }
			return rList[0];

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Property> getProperties() {

		try{

			ResourceOwnerPasswordResourceDetails rOwner = new ResourceOwnerPasswordResourceDetails();
			rOwner.setAccessTokenUri(ACCESS_TOKEN_URI);
			rOwner.setClientId(CLIENT_ID);
			rOwner.setClientSecret(CLIENT_SECRET);
			rOwner.setGrantType(GRANT_TYPE);
			rOwner.setUsername(USER_NAME);
			rOwner.setPassword(PASSWORD);

			OAuth2RestTemplate oAuthRestTemplate = new OAuth2RestTemplate(rOwner);

			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.setContentType( MediaType.APPLICATION_FORM_URLENCODED );

			OAuth2AccessToken token = oAuthRestTemplate.getAccessToken();
			//print("Token: " + token);

			Http request = new Http("GET",
					SNAPSHOT_HOST,
					PROPERTIES_URI);
			request.addHeader("Authorization", "Bearer " + token);
			//start=2017-01-01
			//&end=2018-01-01&time_filter=created&res_status=confirmed&include_revenue_details=true&cursor=0&limit=2"
			
			String contents = request.executeRequest();
			List<Property> properties = Arrays.asList(mapper.readValue(contents, Property[].class));
			
			for(Property property : properties) {
	            		print("property_log " + property);
	         }

			return properties;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void loadReservationData() {
		List<String> errors = new ArrayList<String>();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			//Path start = Paths.get(loader.getResource("reservations.json").toURI());
			Path start = Paths.get("/Users/jmathaiyan/Documents/hackathon/gs-rest-service-master/complete/src/main/resorces/reservations.json");
			String contents = new String(Files.readAllBytes(start));
			//System.out.println(contents.substring(1, contents.length()-2));
			ObjectMapper mapper = new ObjectMapper();
			ReservationList rList = mapper.readValue(contents.substring(1, contents.length()-2), ReservationList.class);
			for(Reservations res : rList.getReservations()) {
				print("Reservation :" + res);
			}

		}catch (Exception e) {
			e.printStackTrace();
			print("Error processing configuration files.");
		}
		print("Errors List:" + errors);
	}

	public static void main(String[] args) {
		Oauth2Util util = new Oauth2Util();
		//util.loadReservationData();
		while(true) {
			util.getReservations();
			util.getProperties();
			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void print(String message) {
		//System.out.println(message);
		logger.info(message);
	}


}
