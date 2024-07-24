package com.rotatingmind.parkinglot.selector;


import com.rotatingmind.parkinglot.data.ParkingSpot;

import java.util.List;
import java.util.Random;

public class RandomSelector implements ParkingSpotSelector {

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        List<ParkingSpot> spots =  parkingSpots.stream().filter(ParkingSpot::isFree).toList();
        Random random = new Random();
        int i = random.nextInt(spots.size());
        return spots.get(i);
    }
}
