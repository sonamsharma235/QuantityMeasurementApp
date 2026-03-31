package com.example.QuantityMeasurementApp.repository;


import com.example.QuantityMeasurementApp.entity.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityMeasurementRepository
        extends JpaRepository<QuantityMeasurementEntity, Long> {
    List<QuantityMeasurementEntity> findByMeasurementTypeIgnoreCase(String measurementType);
}