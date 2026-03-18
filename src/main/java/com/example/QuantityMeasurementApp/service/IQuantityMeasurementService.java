package com.example.QuantityMeasurementApp.service;

import java.util.List;

import com.example.QuantityMeasurementApp.dto.QuantityDTO;
import com.example.QuantityMeasurementApp.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    double add(QuantityDTO q1, QuantityDTO q2);

    double subtract(QuantityDTO q1, QuantityDTO q2);

    double divide(QuantityDTO q1, QuantityDTO q2);
    
    List<QuantityMeasurementEntity> getAll();

	int count();

	void deleteAll();
}
