package com.rotatingmind.designpattern.decorator.movie;

public class MovieBookingDecorator extends Facility {

    private Facility facility;

    public MovieBookingDecorator(Facility facility) {
        this.facility = facility;
        this.description = facility.description;
    }

    @Override
    public double cost() {
        return facility.cost() + (facility.cost() * 18 ) / 100d;
    }
}
