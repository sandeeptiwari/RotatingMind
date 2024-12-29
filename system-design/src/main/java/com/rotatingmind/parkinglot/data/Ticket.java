package com.rotatingmind.parkinglot.data;

import java.time.LocalDateTime;

public class Ticket {

    private  final String refNum;
    private final Vehicle vehicle;

    private boolean isActive = true;

    private LocalDateTime activeTill; // TODO must have release date

    public String getRefNum() {
        return refNum;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    private final ParkingSpot parkingSpot;


    public Ticket(String refNum, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.refNum = refNum;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" + "floor=" + getParkingSpot().getFloorNum() + ", spots=" + getParkingSpot().getName()
                + ", vehicle=" + vehicle + ", isACtive=" + isActive + '}';
    }
}
