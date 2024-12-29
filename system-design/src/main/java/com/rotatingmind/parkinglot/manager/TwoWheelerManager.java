package com.rotatingmind.parkinglot.manager;


import com.rotatingmind.parkinglot.data.ParkingSpot;

import java.util.List;

public class TwoWheelerManager implements VehicleTypeManager{
    @Override
    public List<ParkingSpot> getParkingSpots() {
        return null;
    }

    @Override
    public double getParkingFees(double durationInHours) {
        return 0;
    }
}
