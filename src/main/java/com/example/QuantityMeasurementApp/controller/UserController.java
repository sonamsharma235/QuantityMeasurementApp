package com.example.QuantityMeasurementApp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.QuantityMeasurementApp.dto.UserLoginDTO;
import com.example.QuantityMeasurementApp.dto.UserSignUpDTO;
import com.example.QuantityMeasurementApp.entity.UserEntity;
import com.example.QuantityMeasurementApp.repository.UserRepository;
import com.example.QuantityMeasurementApp.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserSignUpDTO dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDTO dto) {
        return ResponseEntity.ok(service.login(dto));
    }

}
