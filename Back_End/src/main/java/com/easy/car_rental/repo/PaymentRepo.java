package com.easy.car_rental.repo;

import com.easy.car_rental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, String> {
}
