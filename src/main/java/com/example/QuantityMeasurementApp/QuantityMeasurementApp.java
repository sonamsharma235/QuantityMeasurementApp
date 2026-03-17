package com.example.QuantityMeasurementApp;

public class QuantityMeasurementApp {

    public static boolean compare(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {

        QuantityLength q1 = new QuantityLength(value1, unit1);
        QuantityLength q2 = new QuantityLength(value2, unit2);

        return q1.equals(q2);
    }

    public static void main(String[] args) {

        System.out.println(
                "Quantity(1.0, FEET) & Quantity(12.0, INCH) -> "
                        + compare(1.0, LengthUnit.FEET,
                        12.0, LengthUnit.INCH));

        System.out.println(
                "Quantity(1.0, INCH) & Quantity(1.0, INCH) -> "
                        + compare(1.0, LengthUnit.INCH,
                        1.0, LengthUnit.INCH));
    }
}