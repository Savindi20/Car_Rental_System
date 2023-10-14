package com.easy.car_rental.repo;

import com.easy.car_rental.dto.Reg_UserDTO;
import com.easy.car_rental.entity.Reg_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Reg_UserRepo extends JpaRepository<Reg_User, String> {
}
