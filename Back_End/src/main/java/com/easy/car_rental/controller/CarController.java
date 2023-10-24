package com.easy.car_rental.controller;

import com.easy.car_rental.dto.CarDTO;
import com.easy.car_rental.embeded.ImageDTO;
import com.easy.car_rental.embeded.Rate;
import com.easy.car_rental.service.CarService;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto, @ModelAttribute Rate rate, @ModelAttribute ImageDTO image) {
        dto.setImage(image);
        dto.setRent_Duration_Price(rate);

        System.out.println(dto);
        service.saveCar(dto);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/update")
    public ResponseUtil updateCar(@ModelAttribute CarDTO dto, @ModelAttribute Rate rate, @ModelAttribute ImageDTO image) {
        dto.setImage(image);
        dto.setRent_Duration_Price(rate);
        System.out.println(dto.getName());
        System.out.println(dto.getCar_Id());

        System.out.println(dto);
        service.updateCar(dto);
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getCar_Id(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"car_Id"})
    public ResponseUtil deleteCar(@RequestParam String car_Id) {
        service.deleteCar(car_Id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + car_Id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseUtil getAllCar() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllCar());
    }

}