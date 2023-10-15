package com.easy.car_rental.controller;

import com.easy.car_rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

}