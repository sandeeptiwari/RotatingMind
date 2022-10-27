package com.rotatingmind.designpattern.decorator.movie;

public class Platinum extends Facility {

    private final Facility facility;

    public Platinum(Facility facility) {
        this.facility = facility;
        description = "Platinum";
    }
    public String getDeString() {
        return description;
    }

    @Override
    public double cost() {
        return facility.cost() + 200.0;
    }
}
