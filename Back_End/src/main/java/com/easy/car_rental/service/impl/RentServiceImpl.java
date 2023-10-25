package com.easy.car_rental.service.impl;

import com.easy.car_rental.dto.RentDTO;
import com.easy.car_rental.service.RentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Override
    public void bookingCars(RentDTO dto) {

    }

    @Override
    public ArrayList<RentDTO> getAllRent() {
        return null;
    }

    @Override
    public void deleteRent(String rentID) {

    }

    @Override
    public RentDTO searchId(String id) {
        return null;
    }
}
