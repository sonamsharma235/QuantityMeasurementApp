public class Feet {

    private final double value;

    public Feet(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value for Feet");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;                  // Same reference
        if (obj == null) return false;                 // Null check
        if (getClass() != obj.getClass()) return false; // Type check

        Feet other = (Feet) obj;

        return Double.compare(this.value, other.value) == 0;
    }
}