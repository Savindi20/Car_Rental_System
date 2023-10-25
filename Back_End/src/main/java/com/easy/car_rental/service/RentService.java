package com.easy.car_rental.service;

import com.easy.car_rental.dto.CustomDTO;
import com.easy.car_rental.dto.RentDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public interface RentService {

    void bookingCars(@RequestBody RentDTO dto);

    ArrayList <RentDTO> getAllRent();

    void deleteRent(String rentID);

    RentDTO searchId(String id);
}
