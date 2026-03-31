package com.example.QuantityMeasurementApp.repository;

import com.example.QuantityMeasurementApp.entity.OperationHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationHistoryRepository extends JpaRepository<OperationHistoryEntity, Long> {
}