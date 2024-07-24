package com.rotatingmind.parkinglot.selector;


import com.rotatingmind.parkinglot.data.EntryPoint;
import com.rotatingmind.parkinglot.data.ParkingSpot;

import java.util.List;

public class NearestSelector implements ParkingSpotSelector {

    private final EntryPoint entryPoint;

    public NearestSelector(EntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        return null;
    }
}
