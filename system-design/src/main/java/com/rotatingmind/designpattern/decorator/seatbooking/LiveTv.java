package com.rotatingmind.designpattern.decorator.seatbooking;

public class LiveTv extends FlightSeatDecorator {

    public LiveTv(FlightSeat flightSeat) {
        super(flightSeat);
    }

    @Override
    public String getFacilities() {
        return this.flightSeat.getFacilities() + "\n LiveTv";
    }

    @Override
    public Double getCost() {
        return this.flightSeat.getCost() + 30.0;
    }
}
