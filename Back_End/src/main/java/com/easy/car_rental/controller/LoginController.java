package com.easy.car_rental.controller;

import com.easy.car_rental.service.UserService;
import com.easy.car_rental.util.CurrentUser;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
//Backend එකේ ඉදන් යවන ඕනම data format එකක්(String,HTML,JSON),
//HTTP response එකක් විදියට wrap කරල front end එකට යවන්න පුලුවන්.
//(වැවිපුරම use වෙන format එක JSON)
@CrossOrigin
// E kiyanne domains  athi Web Pages walata security feature eka denn
@RequestMapping("/loginForm")
//handler mapping (URL path එකට map කරයි)
public class LoginController {

    @Autowired
    //dependencies inject කරන්න (constructor overloading constructor choose කරයි.)
    private UserService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    //HTTP status code eka response ekk widiyt denwa.
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //request එක Accept=application/json (response json type)
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil getAllRegUser(){
        System.out.println(service.getAllRegUsers());
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAllRegUsers());
    }

    @GetMapping(params = {"username"}) //Query String Parameter
    public ResponseUtil setUser(String username,String password){
        CurrentUser.currentUser=service.getRegUsers(username,password);
        return new ResponseUtil("OK","Successfully Loaded..!","");
    }

    @GetMapping(path = "current") //path variable
    public ResponseUtil getCurrentUser(){
        return new ResponseUtil("OK","Successfully Loaded..!",CurrentUser.currentUser);
    }

}