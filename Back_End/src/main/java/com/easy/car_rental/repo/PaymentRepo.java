package com.easy.car_rental.repo;

import com.easy.car_rental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepo extends JpaRepository<Payment, String> {
    @Query(value = "SELECT paymentID FROM Payment ORDER BY paymentID DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
