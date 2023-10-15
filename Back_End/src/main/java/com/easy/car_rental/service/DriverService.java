package com.easy.car_rental.service;

import com.easy.car_rental.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    void saveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    void deleteDriver(String reg_ID);
    ArrayList<DriverDTO> getAllDriver();
}
