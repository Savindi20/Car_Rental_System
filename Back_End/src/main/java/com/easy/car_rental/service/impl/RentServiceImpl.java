package com.easy.car_rental.service.impl;

import com.easy.car_rental.dto.CustomDTO;
import com.easy.car_rental.dto.RentDTO;
import com.easy.car_rental.repo.CarRepo;
import com.easy.car_rental.repo.DriverRepo;
import com.easy.car_rental.repo.RentRepo;
import com.easy.car_rental.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class RentServiceImpl implements RentService {
    @Autowired
    private RentRepo rentRepo;
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomDTO rentIdGenerate() {
        return null;
    }

    @Override
    public void bookingCars(RentDTO dto) {

    }

    @Override
    public ArrayList<RentDTO> getAllRent() {
        return mapper.map(rentRepo.findAll(), new TypeToken<ArrayList<RentDTO>>() {
        }.getType());
    }

    @Override
    public void deleteRent(String rentID) {

    }

    @Override
    public RentDTO searchId(String id) {
        if (!rentRepo.existsById(id)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        return mapper.map(rentRepo.findById(id).get(), RentDTO.class);

    }
}
