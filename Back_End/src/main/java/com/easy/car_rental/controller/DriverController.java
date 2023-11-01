package com.easy.car_rental.controller;

import com.easy.car_rental.dto.CustomDTO;
import com.easy.car_rental.dto.DriverDTO;
import com.easy.car_rental.dto.UserDTO;
import com.easy.car_rental.embeded.Name;
import com.easy.car_rental.entity.Driver;
import com.easy.car_rental.service.DriverService;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//ඕනම data format එකක data ekk HTTP response එකක් විදියට wrap කරල front end එකට යවන්න පුලුවන්
@CrossOrigin
// domains Web Pages walata security feature eka denna kiyala
@RequestMapping("/driver")
//handler mapping (URL path එකට map කරයි)
public class DriverController {
    @Autowired
    //dependencies inject කරන්න (constructor overloading constructor choose කරයි.)
    private DriverService service;

    @ResponseStatus(HttpStatus.CREATED)
    //HTTP status code eka response ekk widiyt denwa.
    @PostMapping
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        //X-WWW-Form-Url-Encoded type එකේ data, dto එකකට fill කරගන්න use කරයි.(@ModelAttribute-not required)
        driverDTO.setUser(userDTO);
        driverDTO.setName(name);
        service.saveDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/update") //Path variable
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil updateDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        driverDTO.setUser(userDTO);
        driverDTO.setName(name);
        service.updateDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Updated. :" + driverDTO.getUser_Id(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"}) //Query String Parameter
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil deleteDriver(@RequestParam String id) {
        //parameter ඇතුලෙ තියෙන values ගන්න use කරයි (@RequestParam not required)
        service.deleteDriver(id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllDrivers")
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil getAllDriver() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllDriver());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAvalabilityDrivers")
    public ResponseUtil getAllAvalabileDriver() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllAvalabileDriver());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        //@ResponseBody --> return value eka serialized karala kelinma response body ekt dei
        return service.userIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchDriver", params = {"driver_Id"})
    public Driver searchDriverId(String driver_Id) {
        return service.searchDriverId(driver_Id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverCount")
    public @ResponseBody CustomDTO getSumCustomer() {
        return service.getSumDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverAvailableCount")
    public @ResponseBody CustomDTO getSumAvailableDriver() {
        return service.getSumAvailableDriver();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/driverUnavailableCount")
    public @ResponseBody CustomDTO getSumUnavailableDriver() {
        return service.getSumUnavailableDriver();
    }
}