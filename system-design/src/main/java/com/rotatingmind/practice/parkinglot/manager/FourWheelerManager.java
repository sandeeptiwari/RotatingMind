package com.rotatingmind.practice.parkinglot.manager;



import com.rotatingmind.practice.parkinglot.parking.ParkingLot;
import com.rotatingmind.practice.parkinglot.domain.ParkingSpot;
import com.rotatingmind.practice.parkinglot.domain.VehicleType;

import java.util.List;

public class FourWheelerManager implements VehicleTypeManager {
    private final ParkingLot parkingLot;

    public FourWheelerManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public List<ParkingSpot> findParkingSpot() {
        return parkingLot.getParkingSpot(VehicleType.FOUR_WHEELER);
    }

    @Override
    public double getParkingFees(double durationInHours) {
        return durationInHours * 25;
    }
}
