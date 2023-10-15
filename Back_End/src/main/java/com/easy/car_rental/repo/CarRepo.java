package com.easy.car_rental.repo;

import com.easy.car_rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String> {
}