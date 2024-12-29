package com.rotatingmind.parkinglot.selector;


import com.rotatingmind.parkinglot.data.EntryPoint;

public class SpotSelectorFactory {

    private SpotSelectorFactory() {}

    public static ParkingSpotSelector getNearestParkingSpotSelector(
            EntryPoint entryPoint) {
        return new NearestSelector(entryPoint);
    }

    public static ParkingSpotSelector getRandomSelector() {
        return new RandomSelector();
    }

}
