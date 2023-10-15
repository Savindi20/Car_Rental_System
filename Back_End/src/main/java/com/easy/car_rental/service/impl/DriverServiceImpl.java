package com.easy.car_rental.service.impl;

import com.easy.car_rental.dto.DriverDTO;
import com.easy.car_rental.repo.AdminRepo;
import com.easy.car_rental.repo.DriverRepo;
import com.easy.car_rental.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Override
    public void saveDriver(DriverDTO dto) {

    }

    @Override
    public void updateDriver(DriverDTO dto) {

    }

    @Override
    public void deleteDriver(String reg_ID) {

    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        return null;
    }
}