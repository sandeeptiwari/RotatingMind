package com.rotatingmind.parkinglot.manager;


import com.rotatingmind.parkinglot.data.ParkingSpot;

import java.util.List;

public interface VehicleTypeManager {

     List<ParkingSpot> getParkingSpots();

    double getParkingFees(double durationInHours);

}
