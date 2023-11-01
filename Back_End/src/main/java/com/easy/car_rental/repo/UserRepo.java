package com.easy.car_rental.repo;

import com.easy.car_rental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {

    //define custom JPQL (Java Persistence Query Language) and native SQL queries directly on repository methods.
    @Query(value = "select * from User where user_Name=? AND password=? limit 1",nativeQuery = true)
    User findUserByUser_NameAndPassword(String username, String password) throws RuntimeException;
}
