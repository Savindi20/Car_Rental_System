package com.easy.car_rental.controller;

import com.easy.car_rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/loginForm")
public class LoginController {
    @Autowired
    private UserService service;

}