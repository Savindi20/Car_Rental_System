package com.easy.car_rental.service.impl;

import com.easy.car_rental.dto.AdminDTO;
import com.easy.car_rental.entity.Admin;
import com.easy.car_rental.repo.AdminRepo;
import com.easy.car_rental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {


    @Override
    public void saveAdmin(AdminDTO dto) {

    }

    @Override
    public void updateAdmin(AdminDTO dto) {

    }

    @Override
    public void deleteAdmin(String reg_ID) {

    }

    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        return null;
    }
}
