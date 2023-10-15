package com.rotatingmind.carrental.domain;

import com.rotatingmind.carrental.domain.enums.PaymentMode;
import com.rotatingmind.carrental.domain.enums.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Payment {

    private Long paymentId;

    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;

    private double amount;

    private LocalDateTime paymentAt;

    private Long bookingId;

    private String couponCode;
}
