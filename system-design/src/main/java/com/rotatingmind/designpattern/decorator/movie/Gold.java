package com.rotatingmind.designpattern.decorator.movie;

public class Gold extends Facility {

    private final Facility facility;

    public Gold(Facility facility) {
        this.facility = facility;
        description = "Gold";
    }
    public String getDeString() {
        return description;
    }

    @Override
    public double cost() {
        return facility.cost() + 150.0;
    }
}
