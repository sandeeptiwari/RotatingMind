package com.rotatingmind.practice.parkinglot.factory;


import com.rotatingmind.parkinglot.payments.CardDetails;
import com.rotatingmind.practice.parkinglot.payment.CardPaymentProcessor;
import com.rotatingmind.practice.parkinglot.payment.CashPaymentProcessor;
import com.rotatingmind.practice.parkinglot.payment.PaymentProcessor;

public class PaymentProcessorFactory {

    private PaymentProcessorFactory() {}

    public  static PaymentProcessor getCardBasedPaymentProcessor(double amount, CardDetails cardDetails)
    {
        return new CardPaymentProcessor(amount, cardDetails);
    }

    public  static PaymentProcessor getCashBasedPaymentProcessor(double amount)
    {
        return new CashPaymentProcessor(amount);
    }
}
