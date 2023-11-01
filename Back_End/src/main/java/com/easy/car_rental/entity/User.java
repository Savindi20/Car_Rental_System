package com.easy.car_rental.entity;

import com.easy.car_rental.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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
public class User {
    @Id
    //Mark a field as the primary key( unique identifier)
    private String user_Id;
    @Enumerated(EnumType.STRING)
    //specify how an enum should persist in the database.
    private RoleType role_Type;
    private String user_Name;
    private String password;

    public User(RoleType role_Type, String user_Name, String password) {
        this.role_Type = role_Type;
        this.user_Name = user_Name;
        this.password = password;
    }

}