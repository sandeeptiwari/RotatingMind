package com.rotatingmind.practice.parkinglot.selector;



import com.rotatingmind.practice.parkinglot.domain.ParkingSpot;

import java.util.List;

public class RandomSelector implements ParkingSpotSelector {

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> spotList) throws IllegalAccessException {
        return spotList.stream().filter(ParkingSpot::isFree).findFirst().orElseThrow(() -> new IllegalAccessException("No spot is available"));
    }
}
