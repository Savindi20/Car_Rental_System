package com.easy.car_rental.dto;

import com.easy.car_rental.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminDTO {
    private String admin_Id;
    private String role_Type;
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private String password;

}