package com.easy.car_rental.controller;

import com.easy.car_rental.dto.CustomDTO;
import com.easy.car_rental.dto.RentDTO;
import com.easy.car_rental.service.RentService;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//ඕනම data format එකක data ekk HTTP response එකක් විදියට wrap කරල front end එකට යවන්න පුලුවන්
@CrossOrigin
// domains Web Pages walata security feature eka denna kiyala
@RequestMapping("/rent")
//handler mapping (URL path එකට map කරයි)
public class RentController {

    @Autowired
    //dependencies inject කරන්න (constructor overloading constructor choose කරයි.)
    private RentService service;

    @ResponseStatus(HttpStatus.CREATED)
    //HTTP status code eka response ekk widiyt denwa.
    @GetMapping(path = "/rentIdGenerate")//path variable
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public @ResponseBody CustomDTO customerIdGenerate() {
        //(@ResponseBody)return value eka serialized karala kelinma response body ekt dei
        return service.rentIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil placeOrder(@RequestBody RentDTO dto) {
        //bind the HTTP request body to a domain object (Required annotation)
        service.bookingCars(dto);
        return new ResponseUtil("Ok", "Successfully Purchased.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/booking")
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public @ResponseBody CustomDTO getSumOfBooking() {
        return service.getSumOfBooking();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/bookingPending")
    public @ResponseBody CustomDTO getSumOfBookingPending() {
        return service.getSumOfBookingPending();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/bookingActive")
    public @ResponseBody CustomDTO getSumOfBookingActive() {
        return service.getSumOfBookingActive();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllRents")
    public ResponseUtil getAllRents() {
        System.out.println(service.getAllRent());
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllRent());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"}) //Query String Parameter
    public ResponseUtil deleteRent(@RequestParam String id) {
        //parameter ඇතුලෙ තියෙන values ගන්න use කරයි (@RequestParam not required)
        service.deleteRent(id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/rentConfrom", params = {"rentID", "driverId"})
    public ResponseUtil bookingConform(@RequestParam String rentID, @RequestParam String driverId) {
        service.bookingConform(rentID,driverId);
        return new ResponseUtil("OK", "Successfully Conformed.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/rentReject", params = {"rentID", "driverId"})
    public ResponseUtil bookingReject(@RequestParam String rentID, @RequestParam String driverId) {
        service.bookingReject(rentID,driverId);
        return new ResponseUtil("OK", "Successfully Conformed.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchDtails", params = {"search_Id"})
    public RentDTO searchId(String search_Id) {
        return service.searchId(search_Id);
    }

}