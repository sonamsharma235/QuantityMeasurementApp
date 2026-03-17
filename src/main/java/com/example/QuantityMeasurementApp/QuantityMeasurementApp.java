package com.example.QuantityMeasurementApp;

import com.example.QuantityMeasurementApp.controller.QuantityMeasurementController;
import com.example.QuantityMeasurementApp.dto.QuantityDTO;
import com.example.QuantityMeasurementApp.repository.QuantityMeasurementCacheRepository;
import com.example.QuantityMeasurementApp.service.IQuantityMeasurementService;
import com.example.QuantityMeasurementApp.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

	public static void main(String[] args) {

		QuantityMeasurementCacheRepository repository = QuantityMeasurementCacheRepository.getInstance();

		IQuantityMeasurementService service = new QuantityMeasurementServiceImpl(repository);

		QuantityMeasurementController controller = new QuantityMeasurementController(service);

		QuantityDTO q1 = new QuantityDTO(10, "METER");
		QuantityDTO q2 = new QuantityDTO(5, "METER");

		controller.performAddition(q1, q2);
		controller.performSubtraction(q1, q2);
		controller.performDivision(q1, q2);
	}
}