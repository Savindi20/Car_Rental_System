package com.easy.car_rental.controller;

import com.easy.car_rental.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/income")
public class IncomeController {
    @Autowired
    private IncomeService service;

}