package com.easy.car_rental.service;

import com.easy.car_rental.dto.PaymentDTO;

import java.util.ArrayList;

public interface PaymentService {

    void savePayment(PaymentDTO dto,String rentID);

    ArrayList<PaymentDTO> getAllPayment();
}
