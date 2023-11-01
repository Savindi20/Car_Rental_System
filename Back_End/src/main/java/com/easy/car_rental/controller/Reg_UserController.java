package com.easy.car_rental.controller;

import com.easy.car_rental.dto.CustomDTO;
import com.easy.car_rental.dto.Reg_UserDTO;
import com.easy.car_rental.dto.UserDTO;
import com.easy.car_rental.embeded.Name;
import com.easy.car_rental.entity.Reg_User;
import com.easy.car_rental.service.Reg_UserService;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//Backend එකේ ඉදන් යවන ඕනම data format එකක්(String,HTML,JSON),
//HTTP response එකක් විදියට wrap කරල front end එකට යවන්න පුලුවන්.
//(වැවිපුරම use වෙන format එක JSON)
@CrossOrigin
// E kiyanne domains  athi Web Pages walata security feature eka denn
@RequestMapping("/reg_User")
//handler mapping (URL path එකට map කරයි)
public class Reg_UserController {

    @Autowired
    //dependencies inject කරන්න (constructor overloading constructor choose කරයි.)
    private Reg_UserService service;

    @ResponseStatus(HttpStatus.CREATED)
    //HTTP status code eka response ekk widiyt denwa.
    @PostMapping
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil saveUser(@ModelAttribute Reg_UserDTO regUserDTO, @ModelAttribute UserDTO user, @ModelAttribute Name name) {
        //X-WWW-Form-Url-Encoded type එකේ data, dto එකකට fill කරගන්න use කරයි.(@ModelAttribute-not required)
        regUserDTO.setName(name);
        regUserDTO.setUser(user);
        System.out.println(regUserDTO);
        service.saveUser(regUserDTO);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/update") //Path Variables
    public ResponseUtil updateUser(@ModelAttribute Reg_UserDTO regUserDTO, @ModelAttribute UserDTO user, @ModelAttribute Name name) {
        regUserDTO.setName(name);
        regUserDTO.setUser(user);
        System.out.println(user);
        System.out.println(name);
        System.out.println(regUserDTO);
        service.updateUser(regUserDTO);
        return new ResponseUtil("OK", "Successfully Updated. :" + regUserDTO.getUser_Id(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"}) //Query String Parameter
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil deleteUser(@RequestParam String id) {
        service.deleteUser(id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllUsers")
    //http method එක කියන්න Use කරයි. (Handler method උඩින් දාන annotations)
    public ResponseUtil getAllUser() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllUser());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/reg_UserIdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        //(@ResponseBody)return value eka serialized karala kelinma response body ekt dei
        return service.userIdGenerate();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCustomer", params = {"cus_Id"})
    public Reg_User searchDriverId(String cus_Id) {
        return service.searchUserId(cus_Id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/customerCount")
    public @ResponseBody CustomDTO getSumCustomer() {
        return service.getSumUser();
    }

}