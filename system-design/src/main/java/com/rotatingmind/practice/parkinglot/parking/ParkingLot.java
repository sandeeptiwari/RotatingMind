package com.rotatingmind.practice.parkinglot.parking;


import com.rotatingmind.practice.parkinglot.domain.*;
import com.rotatingmind.practice.parkinglot.factory.VehicleTypeManagerFactory;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private static ParkingLot instance = null;
    private Map<String, ParkingFloor> floors;


    private ParkingLot(String name, Map<String, ParkingFloor> floors) {
        this.name = name;
        this.floors = floors;
    }

    public static ParkingLot getInstance(String name, Map<String, ParkingFloor> floors) {
        if (instance == null) {
            instance = new ParkingLot(name, floors);
        }
        return instance;
    }

    public Ticket allocateSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        String floorNum = parkingSpot.getFloorNum();
        ParkingFloor parkingFloor = floors.get(floorNum);
        return parkingFloor.allocateParkingSpot(parkingSpot.getName(), vehicle);
    }



    public List<ParkingSpot> getParkingSpot(VehicleType vehicleType) {
        return floors.entrySet().stream().map(Map.Entry::getValue)
                .flatMap(floor -> floor.getParkingSpotByVehicleType(vehicleType).stream())
                .toList();
    }

    public double calculateParkingFees(Ticket ticket) {
        String floorNum = ticket.getParkingSpot().getFloorNum();
        ParkingFloor parkingFloor = floors.get(floorNum);
        double duration = parkingFloor.getParkingDuration(ticket.getRefNum());

        return VehicleTypeManagerFactory
                .vehicleTypeManager(ticket.getVehicle().getVehicleType(), this)
                .getParkingFees(duration);
    }

    public void vacateParkingSpot(Ticket ticket) {
        String floorNum = ticket.getParkingSpot().getFloorNum();
        ParkingFloor parkingFloor = floors.get(floorNum);
        parkingFloor.vacateParkingSpot(ticket);
    }
}
