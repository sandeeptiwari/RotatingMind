package com.rotatingmind.parkinglot.data;

public class ParkingSpot {

    private final String floorNum;
    private final VehicleType vehicleType;
    private boolean isFree = true;
    private final String name;
    private Vehicle vehicle;


    public String getFloorNum() {
        return floorNum;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return isFree;
    }


    public ParkingSpot(String floorNum, VehicleType vehicleType,
                       String name, boolean isFree) {
        this.floorNum = floorNum;
        this.vehicleType = vehicleType;
        this.name = name;
        this.isFree = isFree;
    }

    public boolean assignVehicle(Vehicle vehicle) {

        System.out.println("Assign " + name + " at floor "
                + floorNum +  " to " + vehicle);

        this.isFree = false;
        this.vehicle = vehicle;

        return true;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
