package com.rotatingmind.practice.parkinglot.parking;


import com.rotatingmind.parkinglot.payments.PaymentMode;
import com.rotatingmind.practice.parkinglot.domain.*;
import com.rotatingmind.practice.parkinglot.manager.ParkingManager;

public class ParkingSystem implements Parking {

    private final ParkingManager parkingManager;

    public ParkingSystem(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }


    @Override
    public Ticket parkVehicle(Vehicle vehicle) throws IllegalAccessException {
        EntryPoint entryPoint = new EntryPoint("East", true);

        //find available spot on specific floor
        ParkingSpot parkingSpot = parkingManager.findparkingSpot(vehicle.getVehicleType(), entryPoint, SpotSelection.RANDOM);

        // Get ticket for parking the vehicle on selected spot

        return parkingManager.getTicket(vehicle, parkingSpot);
    }

    @Override
    public Boolean unParkVehicle(Ticket ticket) throws PaymentFailedException {
        //calculate parking fee
        double parkingFees = parkingManager.getParkingFees(ticket);
        // pay parking fees
        boolean isPaid = parkingManager.payParkingFees(ticket, PaymentMode.CASH, parkingFees);

        if (isPaid) {
            parkingManager.vacateParkingSpot(ticket);
        } else {
            throw new PaymentFailedException("Please try again. The payment was unsuccessful.");
        }
        return true;
    }
}
