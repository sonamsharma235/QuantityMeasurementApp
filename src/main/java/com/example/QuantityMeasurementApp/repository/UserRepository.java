package com.example.QuantityMeasurementApp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.QuantityMeasurementApp.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	Optional<User> findByUsername(String username);

}
