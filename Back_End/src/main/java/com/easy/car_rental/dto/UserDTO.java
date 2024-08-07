package com.easy.car_rental.dto;

import com.easy.car_rental.enums.RoleType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//getters ,setters ,equals,hashcode to string wani methods ganarate karanna use karanawa
@NoArgsConstructor
//automatically generate a no-argument contractor
@ToString
//automatically generate a to string() method for clz
public class UserDTO {
    private String user_Id;
    private RoleType role_Type;
    private String user_Name;
    private String password;

    public UserDTO(RoleType role_Type, String user_Name, String password) {
        this.role_Type = role_Type;
        this.user_Name = user_Name;
        this.password = password;
    }

}