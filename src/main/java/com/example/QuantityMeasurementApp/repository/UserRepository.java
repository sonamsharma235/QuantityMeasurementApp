package com.example.QuantityMeasurementApp.repository;


import com.example.QuantityMeasurementApp.entity.UserEntity;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmailIgnoreCase(String email);
}
