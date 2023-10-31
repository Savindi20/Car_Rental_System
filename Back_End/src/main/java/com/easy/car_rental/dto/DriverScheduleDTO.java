package com.easy.car_rental.dto;

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
public class DriverScheduleDTO {
    private String driverID;
    private String rentID;

}