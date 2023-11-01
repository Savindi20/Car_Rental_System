package com.easy.car_rental.controller;

import com.easy.car_rental.dto.CustomDTO;
import com.easy.car_rental.dto.PaymentDTO;
import com.easy.car_rental.service.PaymentService;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//ඕනම data format එකක data ekk HTTP response එකක් විදියට wrap කරල front end එකට යවන්න පුලුවන්
@CrossOrigin
// domains Web Pages walata security feature eka denna kiyala
@RequestMapping("/payment")
//handler mapping (URL path එකට map කරයි)
public class PaymentController {

    @Autowired
    //dependencies inject කරන්න (constructor overloading constructor choose කරයි.)
    private PaymentService service;

    @ResponseStatus(HttpStatus.CREATED)
    //HTTP status code eka response ekk widiyt denwa.
    @GetMapping(path = "/paymentIdGenerate")//path variable
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public @ResponseBody CustomDTO customerIdGenerate() {
        //(@ResponseBody)return value eka serialized karala kelinma response body ekt dei
        return service.paymentIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil savePayment(@RequestBody PaymentDTO dto, @RequestParam String rentID) {
        //bind the HTTP request body to a domain object (Required annotation)
        //parameter ඇතුලෙ තියෙන values ගන්න use කරයි (@RequestParam not required)
        System.out.println(dto);
        System.out.println(rentID);
        service.savePayment(dto, rentID);
        return new ResponseUtil("OK", "Successfully Payment.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseUtil getAllPayment() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllPayment());
    }
}
