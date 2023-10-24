package com.easy.car_rental.repo;

import com.easy.car_rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car,String> {

    @Query(value = "SELECT car_Id FROM Car ORDER BY car_Id DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(car_Id) FROM Car", nativeQuery = true)
    int getSumCar();

    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE vehicleAvailabilityType='AVAILABLE';", nativeQuery = true)
    int getSumAvailableCar();

    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE vehicleAvailabilityType='UNAVAILABLE';", nativeQuery = true)
    int getSumReservedCar();

    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE vehicleAvailabilityType='MAINTAIN';", nativeQuery = true)
    int getSumMaintainCar();

    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE vehicleAvailabilityType='UNDER_MAINTAIN';", nativeQuery = true)
    int getSumUnderMaintainCar();

}