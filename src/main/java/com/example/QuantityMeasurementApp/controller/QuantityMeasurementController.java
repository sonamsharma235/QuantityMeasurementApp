package com.example.QuantityMeasurementApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.QuantityMeasurementApp.core.Quantity;
import com.example.QuantityMeasurementApp.dto.QuantityRequestDTO;
import com.example.QuantityMeasurementApp.dto.TwoQuantityRequestDTO;
import com.example.QuantityMeasurementApp.entity.OperationHistoryEntity;
import com.example.QuantityMeasurementApp.service.QuantityMeasurementServiceImpl;
import com.example.QuantityMeasurementApp.units.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1")
public class QuantityMeasurementController {

    private final QuantityMeasurementServiceImpl service;

    public QuantityMeasurementController(QuantityMeasurementServiceImpl service) {
        this.service = service;
    }

    // DTO → Domain
    private Quantity<?> toDomain(QuantityRequestDTO dto) {
        IMeasurable unit = getUnit(dto.getMeasurementType(), dto.getUnit());
        return new Quantity<>(dto.getQuantityValue(), unit);
    }

    private IMeasurable getUnit(String type, String unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        switch (type) {
            case "LengthUnit":
                return LengthUnit.valueOf(unit.toUpperCase());
            case "WeightUnit":
                return WeightUnit.valueOf(unit.toUpperCase());
            case "VolumeUnit":
                return VolumeUnit.valueOf(unit.toUpperCase());
            case "TemperatureUnit":
                return TemperatureUnit.valueOf(unit.toUpperCase());
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    // ✅ ADD
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody TwoQuantityRequestDTO dto,
                                 Authentication authentication) throws Exception {

        String email = authentication.getName();

        Quantity<?> q1 = toDomain(dto.getQuantity1());
        Quantity<?> q2 = toDomain(dto.getQuantity2());

        return ResponseEntity.ok(service.add(q1, q2, email));
    }

    // ✅ SUBTRACT
    @PostMapping("/subtract")
    public ResponseEntity<?> subtract(@RequestBody TwoQuantityRequestDTO dto,
                                      Authentication authentication) throws Exception {

        String email = authentication.getName();

        Quantity<?> q1 = toDomain(dto.getQuantity1());
        Quantity<?> q2 = toDomain(dto.getQuantity2());

        return ResponseEntity.ok(service.subtract(q1, q2, email));
    }

    // ✅ DIVIDE
    @PostMapping("/divide")
    public ResponseEntity<?> divide(@RequestBody TwoQuantityRequestDTO dto,
                                    Authentication authentication) throws Exception {

        String email = authentication.getName();

        return ResponseEntity.ok(
                service.divide(
                        toDomain(dto.getQuantity1()),
                        toDomain(dto.getQuantity2()),
                        email
                )
        );
    }

    // ✅ EQUALS
    @PostMapping("/equals")
    public ResponseEntity<?> equals(@RequestBody TwoQuantityRequestDTO dto,
                                    Authentication authentication) throws Exception {

        String email = authentication.getName();

        return ResponseEntity.ok(
                service.checkEquality(
                        toDomain(dto.getQuantity1()),
                        toDomain(dto.getQuantity2()),
                        email
                )
        );
    }

    // ✅ CONVERT (FIXED SYNTAX)
    @PostMapping("/convert")
    public ResponseEntity<?> convert(@RequestBody QuantityRequestDTO dto,
                                     Authentication authentication) {

        String email = authentication.getName();

        Quantity<?> q = toDomain(dto);
        IMeasurable target = getUnit(dto.getMeasurementType(), dto.getTargetUnit());

        return ResponseEntity.ok(service.convert(q, target, email));
    }

    // ✅ HISTORY
    @GetMapping("/history")
    public List<OperationHistoryEntity> getHistory(Authentication authentication) {

        String email = authentication.getName();
        return service.getUserHistory(email);
    }
}


//package com.example.QuantityMeasurementApp.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.QuantityMeasurementApp.core.Quantity;
//import com.example.QuantityMeasurementApp.dto.QuantityRequestDTO;
//import com.example.QuantityMeasurementApp.dto.TwoQuantityRequestDTO;
//import com.example.QuantityMeasurementApp.entity.OperationHistoryEntity;
//import com.example.QuantityMeasurementApp.entity.UserEntity;
//import com.example.QuantityMeasurementApp.repository.UserRepository;
//import com.example.QuantityMeasurementApp.service.QuantityMeasurementServiceImpl;
//import com.example.QuantityMeasurementApp.units.IMeasurable;
//import com.example.QuantityMeasurementApp.units.LengthUnit;
//import com.example.QuantityMeasurementApp.units.TemperatureUnit;
//import com.example.QuantityMeasurementApp.units.VolumeUnit;
//import com.example.QuantityMeasurementApp.units.WeightUnit;
//import org.springframework.security.core.Authentication;
//
//@CrossOrigin(origins = "http://localhost:5173")
//@RestController
//@RequestMapping("/api/v1")
//public class QuantityMeasurementController {
//
//	private final QuantityMeasurementServiceImpl service;
//
//	public QuantityMeasurementController(QuantityMeasurementServiceImpl service) {
//		this.service = service;
//	}
//
//	// 🔹 Convert DTO → Domain
//	private Quantity<?> toDomain(QuantityRequestDTO dto) {
//		IMeasurable unit = getUnit(dto.getMeasurementType(), dto.getUnit());
//		return new Quantity<>(dto.getQuantityValue(), unit);
//	}
//
//	// 🔹 SIMPLE unit logic (no Map)
//	private IMeasurable getUnit(String type, String unit) {
//		if (unit == null) {
//			throw new IllegalArgumentException("Unit cannot be null");
//		}
//		switch (type) {
//			case "LengthUnit":
//				return LengthUnit.valueOf(unit.toUpperCase());
//			case "WeightUnit":
//				return WeightUnit.valueOf(unit.toUpperCase());
//			case "VolumeUnit":
//				return VolumeUnit.valueOf(unit.toUpperCase());
//			case "TemperatureUnit":
//				return TemperatureUnit.valueOf(unit.toUpperCase());
//			default:
//				throw new IllegalArgumentException("Invalid type");
//		}
//	}
//
//	@PostMapping("/add")
//	public ResponseEntity<?> add(@RequestBody TwoQuantityRequestDTO dto) throws Exception {
//		Quantity<?> q1 = toDomain(dto.getQuantity1());
//		Quantity<?> q2 = toDomain(dto.getQuantity2());
//
//
//		return ResponseEntity.ok(service.add(q1, q2));
//	}
//
//	@PostMapping("/subtract")
//	public ResponseEntity<?> subtract(@RequestBody TwoQuantityRequestDTO dto) throws Exception {
//		Quantity<?> q1 = toDomain(dto.getQuantity1());
//		Quantity<?> q2 = toDomain(dto.getQuantity2());
//
//		return ResponseEntity.ok(service.subtract(q1, q2));
//	}
//
//	@PostMapping("/convert")
//	public ResponseEntity<?> convert(@RequestBody QuantityRequestDTO dto,) {
//		String email = authentication.getName();
//
//		Quantity<?> q = toDomain(dto);
//		IMeasurable target = getUnit(dto.getMeasurementType(), dto.getTargetUnit());
//
//		return ResponseEntity.ok(service.convert(q, target, email));
//	}
//
//	@PostMapping("/equals")
//	public ResponseEntity<?> equals(@RequestBody TwoQuantityRequestDTO dto) throws Exception {
//		return ResponseEntity.ok(
//				service.checkEquality(
//						toDomain(dto.getQuantity1()),
//						toDomain(dto.getQuantity2())
//				)
//		);
//	}
//
//	@PostMapping("/divide")
//	public ResponseEntity<?> divide(@RequestBody TwoQuantityRequestDTO dto) throws Exception {
//		return ResponseEntity.ok(
//				service.divide(
//						toDomain(dto.getQuantity1()),
//						toDomain(dto.getQuantity2())
//				)
//		);
//	}
//	
//	@GetMapping("/history")
//	public List<OperationHistoryEntity> getHistory(
//	        org.springframework.security.core.Authentication authentication
//	) {
//	    String email = authentication.getName();
//
//	    return service.getUserHistory(email);
//	}
//}
