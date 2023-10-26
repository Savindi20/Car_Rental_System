package com.easy.car_rental.service.impl;

import com.easy.car_rental.dto.CustomDTO;
import com.easy.car_rental.dto.PaymentDTO;
import com.easy.car_rental.entity.Car;
import com.easy.car_rental.entity.Driver;
import com.easy.car_rental.entity.Payment;
import com.easy.car_rental.entity.Rent;
import com.easy.car_rental.repo.CarRepo;
import com.easy.car_rental.repo.DriverRepo;
import com.easy.car_rental.repo.PaymentRepo;
import com.easy.car_rental.repo.RentRepo;
import com.easy.car_rental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static com.easy.car_rental.enums.AvailabilityType.AVAILABLE;
import static com.easy.car_rental.enums.AvailabilityType.UNDER_MAINTAIN;
import static com.easy.car_rental.enums.RentRequest.PAY;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void savePayment(PaymentDTO dto, String rentID) {

    }

    @Override
    public ArrayList<PaymentDTO> getAllPayment() {
        return null;
    }
}
