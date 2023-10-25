package com.easy.car_rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RentDTO {

    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private String location;
    private Reg_UserDTO regUser;

}
