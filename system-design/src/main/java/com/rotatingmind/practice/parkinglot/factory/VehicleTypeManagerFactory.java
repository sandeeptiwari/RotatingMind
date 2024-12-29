package com.rotatingmind.practice.parkinglot.factory;


import com.rotatingmind.practice.parkinglot.parking.ParkingLot;
import com.rotatingmind.practice.parkinglot.domain.VehicleType;
import com.rotatingmind.practice.parkinglot.manager.FourWheelerManager;
import com.rotatingmind.practice.parkinglot.manager.HeavyVehicleManager;
import com.rotatingmind.practice.parkinglot.manager.TwoWheelerManager;
import com.rotatingmind.practice.parkinglot.manager.VehicleTypeManager;

public class VehicleTypeManagerFactory {

    public static VehicleTypeManager vehicleTypeManager(VehicleType vehicleType, ParkingLot parkingLot) {
        return switch (vehicleType) {
            case HEAVY -> new HeavyVehicleManager(parkingLot);
            case FOUR_WHEELER -> new FourWheelerManager(parkingLot);
            case TWO_WHEELER -> new TwoWheelerManager(parkingLot);
        };
    }
}
