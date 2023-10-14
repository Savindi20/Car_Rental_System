package com.easy.car_rental.controller;

import com.easy.car_rental.dto.Reg_UserDTO;
import com.easy.car_rental.service.Reg_UserService;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reg_User")
public class Reg_UserController {

    @Autowired
    private Reg_UserService service;


}