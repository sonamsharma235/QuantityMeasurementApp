package com.example.QuantityMeasurementApp.units;

import com.example.QuantityMeasurementApp.exception.UnsupportedOperationException;

import com.example.QuantityMeasurementApp.utils.SupportArithmetic;

public interface IMeasurable {
    SupportArithmetic supportsArithmetic = () -> true;

    public String getUnitName();

    public double getConversionFactor();

    public double convertToBaseUnit(double value);

    public double convertFromBaseUnit(double baseValue);

    default boolean supportsArithmetic(){
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation) throws UnsupportedOperationException {}
}