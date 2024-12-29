package com.rotatingmind.practice.parkinglot.selector;



import com.rotatingmind.practice.parkinglot.domain.EntryPoint;
import com.rotatingmind.practice.parkinglot.domain.ParkingSpot;

import java.util.List;

public class NearestSelector implements ParkingSpotSelector  {

    private final EntryPoint entryPoint;

    public NearestSelector(EntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> spotList) {
        return null;
    }
}
