package com.rotatingmind.practice.parkinglot.parking;


import com.rotatingmind.practice.parkinglot.domain.ParkingSpot;
import com.rotatingmind.practice.parkinglot.manager.VehicleTypeManager;
import com.rotatingmind.practice.parkinglot.selector.ParkingSpotSelector;

public class ParkingSpotFinder {

    private final VehicleTypeManager vehicleTypeManager;
    private final ParkingSpotSelector parkingSpotSelector;

    public ParkingSpotFinder(VehicleTypeManager vehicleTypeManager, ParkingSpotSelector parkingSpotSelector) {
        this.vehicleTypeManager = vehicleTypeManager;
        this.parkingSpotSelector = parkingSpotSelector;
    }

    public ParkingSpot findParkingSpot() throws IllegalAccessException {
       return parkingSpotSelector.selectSpot(vehicleTypeManager.findParkingSpot());
    }


}
