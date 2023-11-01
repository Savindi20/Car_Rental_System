package com.easy.car_rental.entity;

import com.easy.car_rental.embeded.Image;
import com.easy.car_rental.embeded.Rate;
import com.easy.car_rental.enums.AvailabilityType;
import com.easy.car_rental.enums.CarType;
import com.easy.car_rental.enums.FuelType;
import com.easy.car_rental.enums.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
//class will be mapped to a database table
@Data
//getters ,setters ,equals,hashcode to string wani methods generate karanna use karanawa
@NoArgsConstructor
//automatically generate a no-argument contractor
@AllArgsConstructor
//automatically generate a parameters contractor
@ToString
//automatically generate a to string() method for clz
public class Car {
    @Id
    //Mark a field as the primary key( unique identifier)
    private String car_Id;
    private String name;
    private String brand;
    @Enumerated(EnumType.STRING)
    //specify how an enum should persist in the database.
    private CarType type;
    @Embedded
    //embed a class in another class as a value type.
    private Image image;
    private int number_Of_Passengers;
    @Enumerated(EnumType.STRING)
    private TransmissionType transmission_Type;
    @Enumerated(EnumType.STRING)
    private FuelType fuel_Type;
    @Embedded
    private Rate rent_Duration_Price;
    private double price_Extra_KM;
    private String registration_Number;
    private double free_Mileage;
    private String color;
    @Enumerated(EnumType.STRING)
    private AvailabilityType vehicleAvailabilityType;

}