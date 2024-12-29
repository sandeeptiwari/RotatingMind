package com.rotatingmind.practice.parkinglot.parking;



import com.rotatingmind.practice.parkinglot.domain.ParkingSpot;
import com.rotatingmind.practice.parkinglot.domain.Ticket;
import com.rotatingmind.practice.parkinglot.domain.Vehicle;
import com.rotatingmind.practice.parkinglot.domain.VehicleType;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

record ParkingTicket(LocalDateTime inTime, LocalDateTime outTime, Ticket ticket, boolean isActive) {}

public class ParkingFloor {
    private final String name;
    private final int totalSpots;
    //spotname, spot
    private final Map<String, ParkingSpot> parkingSpots = new LinkedHashMap<>();

    // here, I use a Set, but you may want to hold the parking
    // tickets is a certain order to optimize search
    private final Map<String, ParkingTicket> parkingTickets = new HashMap<>();

    private int totalFreeSpace;

    public ParkingFloor(String name, int totalSpots) {
        this.name = name;
        this.totalSpots = totalSpots;
        initialize(name, totalSpots); //create the parking spots
    }

    private void initialize(String floorNum, int totalSpots) {
        Random random = new Random();
        for (int i = 0; i < totalSpots; i++) {
            int ordinal = random.nextInt(VehicleType.values().length);
            VehicleType vehicleType = VehicleType.values()[ordinal];
            String spotNum = vehicleType.name().substring(0, 1) + i;
            ParkingSpot p1 = new ParkingSpot(floorNum, vehicleType, spotNum, true);
            parkingSpots.put(spotNum, p1);
        }
    }

    public List<ParkingSpot> getParkingSpotByVehicleType(VehicleType vehicleType) {
        return parkingSpots.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(spot -> spot.getVehicleType() == vehicleType)
                .toList();
    }

    public Ticket allocateParkingSpot(String name, Vehicle vehicle) {
        ParkingSpot parkingSpot = parkingSpots.get(name);
        if (!parkingSpot.isFree()) {
            return null;
        } // returning null is not a good practice

        boolean isParked = parkingSpot.assignVehicle(vehicle);
        long now = Instant.now().getEpochSecond();
        String refNum = vehicle.getNumber() + "-" + now;
        Ticket ticket = new Ticket(refNum, vehicle, parkingSpot);
        var parkingTicket = new ParkingTicket(LocalDateTime.ofInstant(Instant.ofEpochSecond(now), ZoneId.systemDefault()), null, ticket, true);

        parkingTickets.put(refNum, parkingTicket);
        return ticket;
    }

    public boolean vacateParkingSpot(Ticket ticket) {
        // fetch spot from map
        ParkingSpot parkingSpot = parkingSpots.get(ticket.getParkingSpot().getName());
        parkingSpot.setFree(true);
        //remove ticket from parkingTickets
        ParkingTicket parkingTicket = parkingTickets.get(ticket.getRefNum());
        ticket.setActive(false);

        ParkingTicket releaseTicket = new ParkingTicket(parkingTicket.inTime(), LocalDateTime.now(), ticket, false);
        parkingTickets.put(ticket.getRefNum(), releaseTicket);

        return true;
    }

    public boolean isFull(VehicleType type) {
        return parkingSpots.entrySet().stream()
                .map(Map.Entry::getValue)
                .noneMatch(spot -> spot.getVehicleType() == type && spot.isFree());
    }


    public long getParkingDuration(String ticketRefNum) {
        ParkingTicket parkingTicket = parkingTickets.get(ticketRefNum);
        return Duration.between(parkingTicket.inTime(), LocalDateTime.now()).getSeconds() / 60;
    }
}
