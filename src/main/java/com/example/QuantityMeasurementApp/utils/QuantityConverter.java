package com.example.QuantityMeasurementApp.utils;

import com.example.QuantityMeasurementApp.dto.QuantityDTO;
import com.example.QuantityMeasurementApp.entity.Quantity;
import com.example.QuantityMeasurementApp.units.*;

public class QuantityConverter {

	public static Quantity<?> toEntity(QuantityDTO dto) {

		String unit = dto.getUnit();

		if (isLength(unit)) {
			return new Quantity<>(dto.getValue(), LengthUnit.valueOf(unit));
		} else if (isWeight(unit)) {
			return new Quantity<>(dto.getValue(), WeightUnit.valueOf(unit));
		} else if (isVolume(unit)) {
			return new Quantity<>(dto.getValue(), VolumeUnit.valueOf(unit));
		} else if (isTemperature(unit)) {
			return new Quantity<>(dto.getValue(), TemperatureUnit.valueOf(unit));
		}

		throw new IllegalArgumentException("Unsupported unit: " + unit);
	}

	public static QuantityDTO toDTO(Quantity<?> q) {
		return new QuantityDTO(q.getValue(), q.getUnit().getUnitName());
	}

	private static boolean isLength(String u) {
		try {
			LengthUnit.valueOf(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static boolean isWeight(String u) {
		try {
			WeightUnit.valueOf(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static boolean isVolume(String u) {
		try {
			VolumeUnit.valueOf(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static boolean isTemperature(String u) {
		try {
			TemperatureUnit.valueOf(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}