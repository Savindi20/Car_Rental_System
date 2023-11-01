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
//service clz ekak (business logic ,external API thiyenawa)
@Transactional
//transaction thiyena method, clz adura gannna
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    //dependencies inject කරන්න (constructor overloading constructor choose කරයි.)
    private IncomeRepo incomeService;

    @Autowired
    private ModelMapper mapper;

    @Override
    //Supper class ekaka method ekk gnn
    public ArrayList<IncomeDTO> dailyIncome() {
        return new ArrayList<IncomeDTO>(incomeService.dailyIncome());
    }

    @Override
    public ArrayList<IncomeDTO> monthlyIncome() {
        return new ArrayList<IncomeDTO>(incomeService.MonthlyIncome());
    }

    @Override
    public ArrayList<IncomeDTO> AnnuallyIncome() {
        return new ArrayList<IncomeDTO>(incomeService.AnnuallyIncome());
    }
}