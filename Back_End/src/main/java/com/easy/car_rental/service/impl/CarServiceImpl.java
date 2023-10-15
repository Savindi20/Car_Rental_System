package com.easy.car_rental.service.impl;

import com.easy.car_rental.dto.CarDTO;
import com.easy.car_rental.repo.CarRepo;
import com.easy.car_rental.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {

    }

    @Override
    public void updateCar(CarDTO dto) {

    }

    @Override
    public void deleteCar(String car_Id) {

    }

    @Override
    public ArrayList<CarDTO> getAllCar() {
        return null;
    }
}