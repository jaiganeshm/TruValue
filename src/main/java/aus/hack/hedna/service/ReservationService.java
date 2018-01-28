package aus.hack.hedna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import aus.hack.hedna.domain.Property;
import aus.hack.hedna.domain.ReservationList;
import aus.hack.hedna.util.Oauth2Util;

@Service
public class ReservationService {

	private static String CLIENT_SECRET = "70ddb616-6404-4ab8-bd17-bee588d4a68d";
	private static String CLIENT_ID = "244c2ecc-8b29-44dd-8f57-d9b5649aa751";
	private static String TOKEN_REQUEST_URL = "europewest-api-sandbox.snapshot.technology";
	private static String GRANT_TYPE = "password";
	private static String USER_NAME = "paulgreen@beautifulbellhop.com";
	private static String PASSWORD = "R228ekF3";
	
	Oauth2Util restClient = new Oauth2Util();
	
	public ReservationList getReservations(String propertyId) {
	    return restClient.getReservations();
	}
	
	public List<Property> getProperties() {
	    return restClient.getProperties();
	}

}
