package com.example.QuantityMeasurementApp.dto;

public class QuantityResponse {
    private Object result;
    private String message;

    public QuantityResponse(Object result, String message) {
        this.result = result;
        this.message = message;
    }
}