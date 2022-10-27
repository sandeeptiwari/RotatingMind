package com.rotatingmind.designpattern.decorator.seatbooking;

public class Wifi extends FlightSeatDecorator {

    public Wifi(FlightSeat flightSeat) {
        super(flightSeat);
    }

    @Override
    public String getFacilities() {
        return this.flightSeat.getFacilities() + "\n wifi";
    }

    @Override
    public Double getCost() {
        return this.flightSeat.getCost() + 10.0;
    }
}
