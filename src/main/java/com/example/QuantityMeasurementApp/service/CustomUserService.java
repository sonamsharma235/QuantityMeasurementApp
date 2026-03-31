package com.example.QuantityMeasurementApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.QuantityMeasurementApp.entity.User;
import com.example.QuantityMeasurementApp.repository.UserRepository;
import com.example.QuantityMeasurementApp.exception.UsernameNotFounfException;

@Service
public class CustomUserService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	public CustomUserService(UserRepository repo) {
        this.repo = repo;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFounfException {
		var user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFounfException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().replace("ROLE_", ""))
                .build();
	}
	
}
