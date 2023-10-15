package com.easy.car_rental.dto;

import com.easy.car_rental.embeded.Image;
import com.easy.car_rental.embeded.Rate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDTO {
    private String car_Id;
    private String name;
    private String brand;
    private String type;
    @Embedded
    private Image image;
    private int number_Of_Passengers;
    private String transmission_Type;
    private String fuel_Type;
    @Embedded
    private Rate rent_Duration_Price;
    private String price_Extra_KM;
    private  String registration_Number;
    private int car_qty;
    private String color;
}