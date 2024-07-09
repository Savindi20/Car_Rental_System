package com.easy.car_rental.advisor;

import com.easy.car_rental.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//Handling logic Global exception handle krnn maintain karnn
@CrossOrigin
// eka url ekaka idn thawa url ekakt data access krnn thiyena mechanism ekk
// domains Web Pages walata security feature eka denna kiyala
public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    //HTTP status code eka response ekk widiyt denwa.
    @ExceptionHandler({RuntimeException.class})
    //Controllers walin throw krn exception handle kiranwa.
    public ResponseUtil handleMyExceptions(RuntimeException e) {
        System.out.println(e);
        return new ResponseUtil("Error", e.getMessage(), null);
    }
}