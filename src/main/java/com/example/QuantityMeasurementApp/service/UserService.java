package com.example.QuantityMeasurementApp.service;

import com.example.QuantityMeasurementApp.dto.AuthResponseDTO;
import com.example.QuantityMeasurementApp.dto.UserLoginDTO;
import com.example.QuantityMeasurementApp.dto.UserSignUpDTO;
import com.example.QuantityMeasurementApp.dto.UserResponseDTO;
import com.example.QuantityMeasurementApp.entity.UserEntity;
import com.example.QuantityMeasurementApp.repository.UserRepository;
import com.example.QuantityMeasurementApp.security.JwtUtil;

import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    public UserService(UserRepository repo,PasswordEncoder encoder,JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil=jwtUtil;
    }

    public UserEntity getByEmail(String email) {
        return repo.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
//    public AuthResponseDTO register(UserSignUpDTO dto) {
//
//        if (repo.findByEmail(dto.getEmail()).isPresent()) {
//            throw new RuntimeException("Email already exists");
//        }
//
//        UserEntity user = new UserEntity();
//        user.setUserName(dto.getUserName());
//        user.setEmail(dto.getEmail());
//        user.setPassword(encoder.encode(dto.getPassword()));
//
//        repo.save(user);
//
//        String token = jwtUtil.generateToken(user.getEmail());
//
//        return new AuthResponseDTO(token, "User Registered Successfully");
//    }
    
    public Map<String, Object> register(UserSignUpDTO dto) {

        UserEntity user = new UserEntity();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));

        repo.save(user);

        String token = jwtUtil.generateToken(user.getEmail());

        return Map.of(
            "token", token,
            "name", user.getUserName(),
            "email", user.getEmail()
        );
    }
    
    
    public Map<String, Object> login(UserLoginDTO dto) {

        UserEntity user = repo.findByEmailIgnoreCase(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return Map.of(
            "token", token,
            "name", user.getUserName(),
            "email", user.getEmail()
        );
    }

//    public AuthResponseDTO login(UserLoginDTO dto) {
//
//        UserEntity user = repo.findByEmail(dto.getEmail())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//
//        String token = jwtUtil.generateToken(user.getEmail());
//
//        return new AuthResponseDTO(token, "Login Successful");
//    }
}