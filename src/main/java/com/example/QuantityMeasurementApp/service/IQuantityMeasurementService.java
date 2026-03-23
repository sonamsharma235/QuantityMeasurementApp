package com.example.QuantityMeasurementApp.service;

import com.example.QuantityMeasurementApp.entity.Quantity;
import com.example.QuantityMeasurementApp.units.IMeasurable;

public interface IQuantityMeasurementService {

	<U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2);

	<U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2);

	<U extends IMeasurable> double divide(Quantity<U> q1, Quantity<U> q2);
}