package com.easy.car_rental.entity;

import com.easy.car_rental.embeded.Name;
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
public class Reg_User {
    @Id
    //Mark a field as the primary key( unique identifier)
    private String user_Id;
    @Embedded
    //embed a class in another class as a value type.
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private String license_No;
    private String nic_Img;
    private String license_Img;

    @OneToOne(cascade = CascadeType.ALL)
    //specify a one-to-one relationship
    private User user;
}