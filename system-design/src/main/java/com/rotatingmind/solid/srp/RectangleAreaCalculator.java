package com.rotatingmind.solid.srp;

public class RectangleAreaCalculator {
    private static final double INCH_TERM = 0.025d;
    private final int width;
    private final int height;

    public RectangleAreaCalculator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    // This method breaks SRP
    public double meterToInch(int area) {
        return  area / INCH_TERM;
    }
}
