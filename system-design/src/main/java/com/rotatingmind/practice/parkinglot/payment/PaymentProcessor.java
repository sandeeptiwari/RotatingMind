package com.rotatingmind.practice.parkinglot.payment;

public interface PaymentProcessor {

    boolean executePayment();

    double getAmount();
}
