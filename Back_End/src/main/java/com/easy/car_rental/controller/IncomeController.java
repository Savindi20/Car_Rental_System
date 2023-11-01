package com.easy.car_rental.controller;

import com.easy.car_rental.dto.IncomeDTO;
import com.easy.car_rental.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//Backend එකේ ඉදන් යවන ඕනම data format එකක්(String,HTML,JSON),
//HTTP response එකක් විදියට wrap කරල front end එකට යවන්න පුලුවන්.
//(වැවිපුරම use වෙන format එක JSON)
@CrossOrigin
// E kiyanne domains  athi Web Pages walata security feature eka denn
@RequestMapping("/income")
//handler mapping (URL path එකට map කරයි)
public class IncomeController {
    @Autowired
    //dependencies inject කරන්න (constructor overloading constructor choose කරයි.)
    private IncomeService service;

    @ResponseStatus(HttpStatus.CREATED)
    //HTTP status code eka response ekk widiyt denwa.
    @GetMapping(path = "/dailyIncome") //path variable
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public @ResponseBody ArrayList<IncomeDTO> dailyIncome() {
        //(@ResponseBody)return value eka serialized karala kelinma response body ekt dei
        return service.dailyIncome();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/monthlyIncome")
    public @ResponseBody ArrayList<IncomeDTO> monthlyIncome() {
        return service.monthlyIncome();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/AnnuallyIncome")
    public @ResponseBody ArrayList<IncomeDTO> AnnuallyIncome() {
        return service.AnnuallyIncome();
    }
}