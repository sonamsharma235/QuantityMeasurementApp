package src.main.java.com.example.QuantityMeasurementApp;

public enum VolumeUnit implements IMeasurable {

    GALLON(3.78541),
    LITRE(1.0),
    MILLILITRE(0.001);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }
}