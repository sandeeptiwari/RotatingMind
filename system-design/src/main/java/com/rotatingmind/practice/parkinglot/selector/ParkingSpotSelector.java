package com.rotatingmind.practice.parkinglot.selector;



import com.rotatingmind.practice.parkinglot.domain.ParkingSpot;

import java.util.List;

public interface ParkingSpotSelector {

    ParkingSpot selectSpot(List<ParkingSpot> spotList) throws IllegalAccessException;

}
