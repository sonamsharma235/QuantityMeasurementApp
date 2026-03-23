package com.example.QuantityMeasurementApp.repository;

public interface IQuantityMeasurementRepository {
	void save(String type, String operation, double value1, String unit1, double value2, String unit2, double result,
			String resultUnit);
}