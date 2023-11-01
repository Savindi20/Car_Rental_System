package com.easy.car_rental.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
//Embedded class wenath class wala value type ekk widiyt thiyann puluwn .
//complex data structures represent krnn use kri
@Data
//getters ,setters ,equals,hashcode to string wani methods generate karanna use karanawa
@NoArgsConstructor
//automatically generate a no-argument contractor
@AllArgsConstructor
//automatically generate a parameters contractor
@ToString
//automatically generate a to string() method for clz
public class Rate {
    private double daily_Rate;
    private double monthly_Rate;
}