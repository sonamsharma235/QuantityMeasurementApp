package com.example.QuantityMeasurementApp.config;

import org.springframework.context.annotation.*;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.QuantityMeasurementApp.service.CustomUserService;
import com.example.QuantityMeasurementApp.service.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserService userService;

    public SecurityConfig(CustomUserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/**").permitAll()   // ✅ signup खुला रहेगा
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().permitAll()
            )
            .httpBasic();

        // H2 console fix
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
    