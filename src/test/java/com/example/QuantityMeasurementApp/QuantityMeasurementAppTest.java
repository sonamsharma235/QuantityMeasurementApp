package com.example.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.QuantityMeasurementApp.dto.QuantityDTO;
import com.example.QuantityMeasurementApp.entity.QuantityMeasurementEntity;
import com.example.QuantityMeasurementApp.repository.IQuantityMeasurementRepository;
import com.example.QuantityMeasurementApp.repository.QuantityMeasurementDatabaseRepository;
import com.example.QuantityMeasurementApp.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementAppTest {

	private QuantityMeasurementServiceImpl service;

	@BeforeEach
	void setUp() {
		IQuantityMeasurementRepository repo = new QuantityMeasurementDatabaseRepository();
		service = new QuantityMeasurementServiceImpl(repo);
	}

	@Test
	void testAddition() {
		double result = service.add(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));
		assertEquals(15.0, result);
	}

	@Test
	void testSubtraction() {
		double result = service.subtract(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));
		assertEquals(5.0, result);
	}

	@Test
	void testDivision() {
		double result = service.divide(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));
		assertEquals(2.0, result);
	}

	@Test
	void testNegativeValues() {
		double result = service.add(new QuantityDTO(-10, "LENGTH"), new QuantityDTO(5, "LENGTH"));
		assertEquals(-5.0, result);
	}

	@Test
	void testMultipleOperationsCount() {
		service.add(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));
		service.subtract(new QuantityDTO(20, "LENGTH"), new QuantityDTO(10, "LENGTH"));
		service.divide(new QuantityDTO(50, "LENGTH"), new QuantityDTO(5, "LENGTH"));

		assertEquals(3, service.count());
	}

	@Test
	void testGetAll() {
		service.add(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));

		List<QuantityMeasurementEntity> list = service.getAll();

		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	void testDeleteAll() {
		service.add(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));

		service.deleteAll();

		assertEquals(0, service.count());
	}

	@Test
	void testStoredEntityData() {
		service.add(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));

		List<QuantityMeasurementEntity> list = service.getAll();

		QuantityMeasurementEntity e = list.get(0);

		assertEquals("LENGTH", e.getMeasurementType());
		assertEquals("ADD", e.getOperationType());
		assertEquals(10.0, e.getValue1());
		assertEquals(5.0, e.getValue2());
		assertTrue(e.isResult());
	}

	@Test
	void testAdditionWithZero() {
		double result = service.add(new QuantityDTO(0, "LENGTH"), new QuantityDTO(25, "LENGTH"));
		assertEquals(25.0, result);
	}

	@Test
	void testSubtractSameNumbers() {
		double result = service.subtract(new QuantityDTO(10, "LENGTH"), new QuantityDTO(10, "LENGTH"));
		assertEquals(0.0, result);
	}

	@Test
	void testDivisionDecimal() {
		double result = service.divide(new QuantityDTO(10, "LENGTH"), new QuantityDTO(4, "LENGTH"));
		assertEquals(2.5, result);
	}

	@Test
	void testLargeValues() {
		double result = service.add(new QuantityDTO(1_000_000, "LENGTH"), new QuantityDTO(2_000_000, "LENGTH"));
		assertEquals(3_000_000, result);
	}

	@Test
	void testGetAllAfterDelete() {
		service.add(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));

		service.deleteAll();

		List<QuantityMeasurementEntity> list = service.getAll();

		assertTrue(list.isEmpty());
	}

	@Test
	void testAdditionCommutative() {
		double r1 = service.add(new QuantityDTO(10, "LENGTH"), new QuantityDTO(5, "LENGTH"));

		double r2 = service.add(new QuantityDTO(5, "LENGTH"), new QuantityDTO(10, "LENGTH"));

		assertEquals(r1, r2);
	}
}