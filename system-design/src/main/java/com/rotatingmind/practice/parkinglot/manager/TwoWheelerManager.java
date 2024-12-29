package com.rotatingmind.practice.parkinglot.manager;

import com.rotatingmind.practice.parkinglot.domain.ParkingSpot;
import com.rotatingmind.practice.parkinglot.domain.VehicleType;
import com.rotatingmind.practice.parkinglot.parking.ParkingLot;

import java.util.List;

public class TwoWheelerManager implements VehicleTypeManager {

    private final ParkingLot parkingLot;

    public TwoWheelerManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public List<ParkingSpot> findParkingSpot() {
        return parkingLot.getParkingSpot(VehicleType.TWO_WHEELER);
    }

    @Override
    public double getParkingFees(double durationInHours) {
        return durationInHours * 10;
    }
}
