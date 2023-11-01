package com.easy.car_rental.controller;

import com.easy.car_rental.dto.IncomeDTO;
import com.easy.car_rental.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//ඕනම data format එකක data ekk HTTP response එකක් විදියට wrap කරල front end එකට යවන්න පුලුවන්
@CrossOrigin
// domains Web Pages walata security feature eka denna kiyala
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