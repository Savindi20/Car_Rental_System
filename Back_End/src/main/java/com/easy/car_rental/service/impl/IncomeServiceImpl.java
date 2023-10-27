package com.easy.car_rental.service.impl;

import com.easy.car_rental.dto.IncomeDTO;
import com.easy.car_rental.repo.IncomeRepo;
import com.easy.car_rental.service.IncomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepo incomeService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ArrayList<IncomeDTO> dailyIncome() {
        return new ArrayList<IncomeDTO>(incomeService.dailyIncome());
    }

    @Override
    public ArrayList<IncomeDTO> monthlyIncome() {
        return null;
    }

    @Override
    public ArrayList<IncomeDTO> AnnuallyIncome() {
        return null;
    }
}