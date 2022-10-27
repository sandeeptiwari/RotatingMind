package com.rotatingmind.designpattern.decorator.movie;

public class Normal extends Facility {

    private final Facility facility;

    public Normal(Facility facility) {
        this.facility = facility;
        description = "Normal";
    }
    public String getDeString() {
        return description;
    }

    @Override
    public double cost() {
        return this.facility.cost() + 75.0;
    }
}
