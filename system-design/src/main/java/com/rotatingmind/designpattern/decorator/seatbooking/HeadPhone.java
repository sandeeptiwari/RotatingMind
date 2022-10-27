package com.rotatingmind.designpattern.decorator.seatbooking;

public class HeadPhone  extends FlightSeatDecorator {

    public HeadPhone(FlightSeat flightSeat) {
        super(flightSeat);
    }

    @Override
    public String getFacilities() {
        return this.flightSeat.getFacilities() + "\n headphone";
    }

    @Override
    public Double getCost() {
        return this.flightSeat.getCost() + 50.0;
    }
}
