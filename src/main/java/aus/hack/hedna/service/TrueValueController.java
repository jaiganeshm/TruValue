package aus.hack.hedna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aus.hack.hedna.domain.Property;
import aus.hack.hedna.domain.ReservationList;

@CrossOrigin
@RestController
public class TrueValueController {

    @Autowired
    public ReservationService userService;

    @RequestMapping("/guestRatings")
    public ReservationList guestRatings(@RequestParam(value="name", defaultValue="World") String name) {
    		return userService.getReservations("");
    }
    
    @RequestMapping("/getProperties")
    public List<Property> getProperties(@RequestParam(value="name", defaultValue="World") String name) {
    		return userService.getProperties();
    }
    
    @RequestMapping("/authenticate")
    public void authenticate(@RequestParam(value="name", defaultValue="jai") String name) {
        
    }
}