package com.example.QuantityMeasurementApp.repository;

import com.example.QuantityMeasurementApp.entity.OperationHistoryEntity;
import com.example.QuantityMeasurementApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationHistoryRepository extends JpaRepository<OperationHistoryEntity, Long> {

    List<OperationHistoryEntity> findByUser(UserEntity user);
}