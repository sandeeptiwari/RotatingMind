package com.rotatingmind.parkinglot.apis;


import com.rotatingmind.parkinglot.data.EntryPoint;
import com.rotatingmind.parkinglot.data.ParkingSpot;
import com.rotatingmind.parkinglot.data.SpotSelection;
import com.rotatingmind.parkinglot.data.VehicleType;
import com.rotatingmind.parkinglot.finder.ParkingSpotFinder;
import com.rotatingmind.parkinglot.manager.VehicleTypeManager;
import com.rotatingmind.parkinglot.manager.VehicleTypeManagerFactory;
import com.rotatingmind.parkinglot.selector.ParkingSpotSelector;
import com.rotatingmind.parkinglot.selector.SpotSelectorFactory;

public class FindParkingSpotAPI {

    public ParkingSpot findParkingSpot(EntryPoint entryPoint,
                                       VehicleType vehicleType,
                                       SpotSelection spotSelection)
    {
        VehicleTypeManager vehicleTypeManager =
                VehicleTypeManagerFactory.getVehicleTypeManager(vehicleType);
        ParkingSpotSelector parkingSpotSelector;
        if (spotSelection.equals(SpotSelection.RANDOM))
            parkingSpotSelector = SpotSelectorFactory.getRandomSelector();
        else if (spotSelection.equals(SpotSelection.NEAREST))
            parkingSpotSelector = SpotSelectorFactory
                    .getNearestParkingSpotSelector(entryPoint);
        else
            throw new RuntimeException("");
       return  new ParkingSpotFinder(vehicleTypeManager, parkingSpotSelector).findParkingSpot();
    }

}
