package com.easy.car_rental.service;


import com.easy.car_rental.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String car_Id);
    ArrayList<CarDTO> getAllCar();
}
