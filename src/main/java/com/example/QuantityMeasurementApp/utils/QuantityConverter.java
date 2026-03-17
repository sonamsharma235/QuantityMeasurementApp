package com.example.QuantityMeasurementApp.utils;


import com.example.QuantityMeasurementApp.units.LengthUnit;

public class QuantityConverter {

	public static double convert(double value, LengthUnit from, LengthUnit to) {

		double base = from.toBase(value);

		return base / to.toBase(1);
	}
}