package com.rotatingmind.practice.parkinglot.manager;


import com.rotatingmind.practice.parkinglot.domain.ParkingSpot;

import java.util.List;

public interface VehicleTypeManager {

    List<ParkingSpot> findParkingSpot();


    double getParkingFees(double durationInHours);

}
