package com.rotatingmind.parkinglot.payments;


import com.rotatingmind.parkinglot.data.Ticket;
import com.rotatingmind.parkinglot.manager.VehicleTypeManagerFactory;

public class ParkingFeeProcessor {


    public double getParkingFees(Ticket ticket) {

        double duration = 0;
        // figure out the duration
        return VehicleTypeManagerFactory
                .getVehicleTypeManager(ticket.getVehicle().getVehicleType())
                .getParkingFees(duration);
    }

    public boolean processParkingFees(
            Ticket ticket, PaymentProcessor paymentProcessor) {
        if (getParkingFees(ticket) != paymentProcessor.getAmount())
            throw new RuntimeException("");
        return paymentProcessor.executePayment();
    }

}
