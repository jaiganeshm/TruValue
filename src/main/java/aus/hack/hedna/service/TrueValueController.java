package aus.hack.hedna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aus.hack.hedna.domain.ReservationList;

@RestController
public class TrueValueController {

    @Autowired
    public ReservationService userService;

    @RequestMapping("/guestRatings")
    public ReservationList greeting(@RequestParam(value="name", defaultValue="World") String name) {
    		return userService.getReservations("");
    }
    
    @RequestMapping("/authenticate")
    public void authenticate(@RequestParam(value="name", defaultValue="jai") String name) {
        
    }
    
}