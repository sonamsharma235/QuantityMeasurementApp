package com.example.QuantityMeasurementApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementTest {

    // Same value test
    @Test
    void testEquality_SameValue() {
        assertTrue(QuantityMeasuringApp.compareFeet(1.0, 1.0));
        assertTrue(QuantityMeasuringApp.compareInches(2.5, 2.5));
    }

    // Different value test
    @Test
    void testEquality_DifferentValue() {
        assertFalse(QuantityMeasuringApp.compareFeet(1.0, 2.0));
        assertFalse(QuantityMeasuringApp.compareInches(5.0, 6.0));
    }

    // Null comparison test
    @Test
    void testEquality_NullComparison() {
        Feet feet = new Feet(1.0);
        assertFalse(feet.equals(null));
    }

    // Same reference test
    @Test
    void testEquality_SameReference() {
        Feet feet = new Feet(3.0);
        assertTrue(feet.equals(feet));
    }

    // Non-numeric input test
    @Test
    void testEquality_NonNumericInput() {
        assertThrows(IllegalArgumentException.class,
                () -> new Feet(Double.NaN));

        assertThrows(IllegalArgumentException.class,
                () -> new Inches(Double.POSITIVE_INFINITY));
    }
}