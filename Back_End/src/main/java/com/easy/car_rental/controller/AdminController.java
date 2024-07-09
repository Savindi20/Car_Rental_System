package com.easy.car_rental.controller;

import com.easy.car_rental.dto.AdminDTO;
import com.easy.car_rental.service.AdminService;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
//ඕනම data format එකක data ekk HTTP response එකක් විදියට wrap කරල front end එකට යවන්න පුලුවන්
@CrossOrigin
// domains Web Pages walata security features denn
@RequestMapping("/admin")
//handler mapping (URL path එකට map කරයි)
public class AdminController {

    @Autowired
    //dependencies inject කරන්න (constructor overloading constructor choose කරයි.)
    private AdminService service;

    @ResponseStatus(HttpStatus.CREATED)
    //HTTP status code eka response ekk widiyt denwa.
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE) //request එක Accept=application/json (response json type)
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO dto) {
        //bind the HTTP request body to a domain object (Required annotation)
        service.saveAdmin(dto);
        System.out.println(dto);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @PutMapping
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto) {
        service.updateAdmin(dto);
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getUser_Id(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"admin_Id"}) //Query String Parameter
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil deleteAdmin(@RequestParam String admin_Id) {
        //parameter ඇතුලෙ තියෙන values ගන්න use කරයි (@RequestParam not required)
        service.deleteAdmin(admin_Id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + admin_Id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil getAllAdmin() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllAdmin());
    }
}