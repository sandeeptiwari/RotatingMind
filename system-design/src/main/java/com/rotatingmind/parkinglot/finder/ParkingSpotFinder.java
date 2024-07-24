package com.rotatingmind.parkinglot.finder;


import com.rotatingmind.parkinglot.data.ParkingSpot;
import com.rotatingmind.parkinglot.manager.VehicleTypeManager;
import com.rotatingmind.parkinglot.selector.ParkingSpotSelector;

import java.util.List;

public class ParkingSpotFinder {

    private final VehicleTypeManager vehicleTypeManager;
    private final ParkingSpotSelector parkingSpotSelector;

    public ParkingSpotFinder(VehicleTypeManager vehicleTypeManager,
                             ParkingSpotSelector parkingSpotSelector) {
        this.vehicleTypeManager = vehicleTypeManager;
        this.parkingSpotSelector = parkingSpotSelector;
    }

    public ParkingSpot findParkingSpot() {
        List<ParkingSpot> parkingSpots =
                this.vehicleTypeManager.getParkingSpots();
        return this.parkingSpotSelector.selectSpot(parkingSpots);
    }

}
