package com.rotatingmind.parkinglot.manager;


import com.rotatingmind.parkinglot.data.VehicleType;

public class VehicleTypeManagerFactory {


    private VehicleTypeManagerFactory(){}

    public static VehicleTypeManager getVehicleTypeManager(VehicleType vehicleType)
    {
        VehicleTypeManager vehicleTypeManager = null;
        if (vehicleType.equals(VehicleType.TWO_WHEELER))
            vehicleTypeManager = new TwoWheelerManager();


        return vehicleTypeManager;
    }

}
