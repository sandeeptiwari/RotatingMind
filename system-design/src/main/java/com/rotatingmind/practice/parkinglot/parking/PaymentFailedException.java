package com.rotatingmind.practice.parkinglot.parking;

public class PaymentFailedException extends Exception {

    public PaymentFailedException(String message) {
        super(message);
    }

    public PaymentFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}