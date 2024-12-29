package com.rotatingmind.parkinglot.selector;


import com.rotatingmind.parkinglot.data.ParkingSpot;

import java.util.List;

public interface ParkingSpotSelector {

    ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);

}
