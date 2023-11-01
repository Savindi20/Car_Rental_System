package com.easy.car_rental.entity;

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
@IdClass(RentDetail_PK.class)
public class RentDetails {
    @Id
    //Mark a field as the primary key( unique identifier)
    private String carID;
    @Id
    //Mark a field as the primary key( unique identifier)
    private String rentID;

    private String driverID;

    @ManyToOne
    //specify a many-to-one relationship between two entity classes
    @JoinColumn(name = "rentID",referencedColumnName = "rentID",insertable = false,updatable = false)
    //specify the foreign key in database table that represents a relationship between two entity classes.
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "carID",referencedColumnName = "car_Id",insertable = false,updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverID",referencedColumnName = "user_Id",insertable = false,updatable = false)
    private Driver driver;
}