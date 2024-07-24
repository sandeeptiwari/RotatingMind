package com.rotatingmind.practice.parkinglot.domain;

public class Vehicle {

    private final String name;
    private final VehicleType vehicleType;
    private final String number;

    public String getName() {
        return name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public Vehicle(String name,
                   VehicleType vehicleType,
                   String number) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "licensePlate=" + number
                + ", name=" + name + ", type=" + vehicleType + '}';
    }
}
