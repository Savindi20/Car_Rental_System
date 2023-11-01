package com.easy.car_rental.entity;

import com.easy.car_rental.enums.RentRequest;
import com.easy.car_rental.enums.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
public class Rent {
    @Id
    //Mark a field as the primary key( unique identifier)
    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    @Enumerated(EnumType.STRING)
    //specify how an enum should persist in the database.
    private RequestType requestType;
    @Enumerated(EnumType.STRING)
    private RentRequest rentType;
    private String location;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    //specify a many-to-one relationship between two entity classes
    @JoinColumn(name = "userID", referencedColumnName = "user_Id", nullable = false)
    //specify the foreign key in database table that represents a relationship between two entity classes.
    private Reg_User regUser;

    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL)
    //specify a one-to-many relationship between two entity classes
    private List<RentDetails> rentDetails;

}