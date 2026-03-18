package com.example.QuantityMeasurementApp.controller;

import com.example.QuantityMeasurementApp.dto.QuantityDTO;
import com.example.QuantityMeasurementApp.service.IQuantityMeasurementService;
public class QuantityMeasurementController {

	private IQuantityMeasurementService service;

	public QuantityMeasurementController(IQuantityMeasurementService service) {
		this.service = service;
	}

	public void performAddition(QuantityDTO q1, QuantityDTO q2) {

		double result = service.add(q1, q2);

		System.out.println("Addition Result = " + result);
	}

	public void performSubtraction(QuantityDTO q1, QuantityDTO q2) {

		double result = service.subtract(q1, q2);

		System.out.println("Subtraction Result = " + result);
	}

	public void performDivision(QuantityDTO q1, QuantityDTO q2) {

		double result = service.divide(q1, q2);

		System.out.println("Division Result = " + result);
	}
	
	public void showAll() {
		service.getAll().forEach(System.out::println);
	}

	public void showCount() {
		System.out.println("Total Records = " + service.count());
	}

	public void deleteAll() {
		service.deleteAll();
		System.out.println("All records deleted");
	}
}
