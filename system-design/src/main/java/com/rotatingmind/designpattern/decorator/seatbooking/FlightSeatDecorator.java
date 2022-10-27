package com.rotatingmind.designpattern.decorator.seatbooking;

public abstract class FlightSeatDecorator implements FlightSeat{

    protected final FlightSeat flightSeat;

    protected FlightSeatDecorator(FlightSeat flightSeat) {
        this.flightSeat = flightSeat;
    }

    public abstract String getFacilities();

    public abstract Double getCost();
}
