package com.example.QuantityMeasurementApp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.QuantityMeasurementApp.entity.User;
import com.example.QuantityMeasurementApp.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    // ✅ SIGNUP
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        repo.save(user);
        return "User registered successfully";
    }

    // ✅ LOGIN (Basic Auth will handle it)
    @GetMapping("/login")
    public String login() {
        return "Login successful!";
    }
}
