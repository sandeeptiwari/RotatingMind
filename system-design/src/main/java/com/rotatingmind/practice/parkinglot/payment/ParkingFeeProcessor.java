package com.rotatingmind.practice.parkinglot.payment;

public class ParkingFeeProcessor {

    public boolean processParkingFees(PaymentProcessor paymentProcessor) {

        return paymentProcessor.executePayment();
    }
}
