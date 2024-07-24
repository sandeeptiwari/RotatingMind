package com.rotatingmind.practice.parkinglot.factory;


import com.rotatingmind.practice.parkinglot.selector.NearestSelector;
import com.rotatingmind.practice.parkinglot.selector.ParkingSpotSelector;
import com.rotatingmind.practice.parkinglot.selector.RandomSelector;
import com.rotatingmind.practice.parkinglot.domain.EntryPoint;
import com.rotatingmind.practice.parkinglot.domain.SpotSelection;

public class SpotSelectorFactory {

    public static ParkingSpotSelector findSpot(SpotSelection spotSelection, EntryPoint entryPoint) {
        return switch (spotSelection) {
            case RANDOM -> new RandomSelector();
            case NEAREST -> new NearestSelector(entryPoint);
        };
    }
}
