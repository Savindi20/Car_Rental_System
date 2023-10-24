package com.easy.car_rental.controller;

import com.easy.car_rental.service.UserService;
import com.easy.car_rental.util.CurrentUser;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/loginForm")
public class LoginController {
    @Autowired
    private UserService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRegUser(){
        System.out.println(service.getAllRegUsers());
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAllRegUsers());
    }

}