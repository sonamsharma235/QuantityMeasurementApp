package com.example.QuantityMeasurementApp.service;

import com.example.QuantityMeasurementApp.dto.QuantityDTO;

public interface IQuantityMeasurementService {

    double add(QuantityDTO q1, QuantityDTO q2);

    double subtract(QuantityDTO q1, QuantityDTO q2);

    double divide(QuantityDTO q1, QuantityDTO q2);
}
