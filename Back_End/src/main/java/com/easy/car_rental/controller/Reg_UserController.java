package com.easy.car_rental.controller;
import com.easy.car_rental.dto.Reg_UserDTO;
import com.easy.car_rental.service.Reg_UserService;
import com.easy.car_rental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reg_User")
public class Reg_UserController {
    @Autowired
    private Reg_UserService service;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@RequestBody Reg_UserDTO dto) {
        service.saveUser(dto);
        System.out.println(dto);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }
    @PutMapping
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody Reg_UserDTO dto) {
        service.updateUser(dto);
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getUser_Id(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"user_Id"})
    public ResponseUtil deleteUser(@RequestParam String user_Id) {
        service.deleteUser(user_Id);
        return new ResponseUtil("OK", "Successfully Deleted. :" + user_Id, null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseUtil getAllUser() {
        return new ResponseUtil("OK", "Successfully Loaded. :", service.getAllUser());
    }

}