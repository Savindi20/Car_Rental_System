package com.easy.car_rental.dto;

import com.easy.car_rental.enums.RentRequest;
import com.easy.car_rental.enums.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
//getters ,setters ,equals,hashcode to string wani methods ganarate karanna use karanawa
@NoArgsConstructor
//automatically generate a no-argument contractor
@AllArgsConstructor
//automatically generate a parametes contractor
@ToString
//automatically generate a to string() method for clz
public class RentDTO {
    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private RequestType requestType;
    private RentRequest rentType;
    private String location;
    private Reg_UserDTO regUser;
    private List<RentDetailsDTO> rentDetails;
}