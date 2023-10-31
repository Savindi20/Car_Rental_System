package com.easy.car_rental.dto;

import com.easy.car_rental.embeded.ImageDTO;
import com.easy.car_rental.embeded.Rate;
import com.easy.car_rental.enums.AvailabilityType;
import com.easy.car_rental.enums.CarType;
import com.easy.car_rental.enums.FuelType;
import com.easy.car_rental.enums.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
//getters ,setters ,equals,hashcode to string wani methods ganarate karanna use karanawa
@NoArgsConstructor
//automatically generate a no-argument contractor
@AllArgsConstructor
//automatically generate a parametes contractor
@ToString
//automatically generate a to string() method for clz
public class CarDTO {
    private String car_Id;
    private String name;
    private String brand;
    private CarType type;
    private ImageDTO image;
    private int number_Of_Passengers;
    private TransmissionType transmission_Type;
    private FuelType fuel_Type;
    private Rate rent_Duration_Price;
    private double price_Extra_KM;
    private String registration_Number;
    private double free_Mileage;
    private String color;
    private AvailabilityType vehicleAvailabilityType;
}