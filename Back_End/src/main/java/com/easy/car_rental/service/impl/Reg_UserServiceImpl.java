package com.easy.car_rental.service.impl;

import com.easy.car_rental.dto.Reg_UserDTO;
import com.easy.car_rental.entity.Reg_User;
import com.easy.car_rental.repo.Reg_UserRepo;
import com.easy.car_rental.service.Reg_UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Reg_UserServiceImpl implements Reg_UserService {

    @Autowired
    private Reg_UserRepo repo;
    @Autowired
    private ModelMapper mapper;

}