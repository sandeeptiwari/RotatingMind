package com.rotatingmind.practice.parkinglot.manager;

import com.rotatingmind.parkinglot.payments.CardDetails;
import com.rotatingmind.parkinglot.payments.PaymentMode;
import com.rotatingmind.practice.parkinglot.domain.*;
import com.rotatingmind.practice.parkinglot.factory.PaymentProcessorFactory;
import com.rotatingmind.practice.parkinglot.factory.SpotSelectorFactory;
import com.rotatingmind.practice.parkinglot.factory.VehicleTypeManagerFactory;
import com.rotatingmind.practice.parkinglot.parking.ParkingLot;
import com.rotatingmind.practice.parkinglot.parking.ParkingSpotFinder;
import com.rotatingmind.practice.parkinglot.payment.ParkingFeeProcessor;
import com.rotatingmind.practice.parkinglot.payment.PaymentProcessor;
import com.rotatingmind.practice.parkinglot.selector.ParkingSpotSelector;


public class ParkingManager {

    // parking repository
    private final ParkingLot parkingLot;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot findparkingSpot(VehicleType vehicleType, EntryPoint entryPoint, SpotSelection spotSelection) throws IllegalAccessException {

        VehicleTypeManager manager = VehicleTypeManagerFactory.vehicleTypeManager(vehicleType, parkingLot);

        ParkingSpotSelector parkingSpotSelection = SpotSelectorFactory.findSpot(spotSelection, entryPoint);

        return new ParkingSpotFinder(manager, parkingSpotSelection).findParkingSpot();
    }

    public Ticket getTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return parkingLot.allocateSpot(vehicle, parkingSpot);
    }

    public double getParkingFees(Ticket ticket) {
        return parkingLot.calculateParkingFees(ticket);
    }


    public boolean payParkingFees(Ticket ticket, PaymentMode paymentMode, double amount) {
        PaymentProcessor paymentProcessor = null;
        if (paymentMode.equals(PaymentMode.CARD)) {
            CardDetails cardDetails = null;
            // logic to create above object
            paymentProcessor = PaymentProcessorFactory.getCardBasedPaymentProcessor(amount, cardDetails);
        } else if (paymentMode.equals(PaymentMode.CASH)) {
            paymentProcessor = PaymentProcessorFactory.getCashBasedPaymentProcessor(amount);
        } else {
            throw new IllegalArgumentException();
        }
        return new ParkingFeeProcessor().processParkingFees(paymentProcessor);
    }

    public void vacateParkingSpot(Ticket ticket) {
        parkingLot.vacateParkingSpot(ticket);
    }

}
