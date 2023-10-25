package com.easy.car_rental.repo;

import com.easy.car_rental.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepo extends JpaRepository<Rent, String> {

}
