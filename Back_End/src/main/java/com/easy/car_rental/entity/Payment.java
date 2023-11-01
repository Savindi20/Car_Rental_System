package com.easy.car_rental.entity;

import com.easy.car_rental.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
public class Payment {
    @Id
    //Mark a field as the primary key( unique identifier)
    private String paymentID;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    //specify a many-to-one relationship between two entity classes
    @JoinColumn(name = "rentID", referencedColumnName = "rentID", nullable = false)
    //specify the foreign key in database table that represents a relationship between two entity classes.
    private Rent rentID;
    private PaymentType paymentType;
    private LocalDate date;
    private LocalTime time;
    private Double lostDamage;
    private Double rentFee;
    private Double driverFee;
    private Double total;
}