package com.rotatingmind.solid.srp;

public class AreaConverter {
    private static final double INCH_TERM = 0.025d;
    private static final double FEET_TERM = 0.3048d;

    public double meterToInch(int area) {
        return  area / INCH_TERM;
    }

    public double meterToFeet(int area) {
        return  area / FEET_TERM;
    }
}
