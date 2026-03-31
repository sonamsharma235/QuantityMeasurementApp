package com.example.QuantityMeasurementApp.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.QuantityMeasurementApp.exception.UsernameNotFounfException;

public interface UserDetailsService {
	 UserDetails loadUserByUsername(String username) throws UsernameNotFounfException;
}
