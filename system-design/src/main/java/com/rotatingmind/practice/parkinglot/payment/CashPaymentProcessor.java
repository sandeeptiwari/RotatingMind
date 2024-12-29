package com.rotatingmind.practice.parkinglot.payment;

public class CashPaymentProcessor implements PaymentProcessor {

    private final double amount;

    public CashPaymentProcessor(double amount) {
        this.amount = amount;
    }


    @Override
    public boolean executePayment() {
        return true;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
