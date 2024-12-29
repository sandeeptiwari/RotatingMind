package com.rotatingmind.parkinglot.payments;

public interface PaymentProcessor {

    boolean executePayment();

    double getAmount();
}
