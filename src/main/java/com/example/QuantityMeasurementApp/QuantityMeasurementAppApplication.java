package com.example.QuantityMeasurementApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class QuantityMeasurementAppApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure()
        .ignoreIfMissing()
        .load();

		System.setProperty("GOOGLE_CLIENT_ID", dotenv.get("GOOGLE_CLIENT_ID"));
        System.setProperty("GOOGLE_CLIENT_SECRET", dotenv.get("GOOGLE_CLIENT_SECRET"));
		
		SpringApplication.run(QuantityMeasurementAppApplication.class, args);
		System.out.println("Application started");
	}

}
