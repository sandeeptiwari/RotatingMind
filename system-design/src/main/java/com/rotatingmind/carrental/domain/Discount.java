package com.rotatingmind.carrental.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Discount {
    private Long id;

    private String couponName;

    private LocalDateTime startAt;

    private LocalDateTime expiredAt;

    private double discountAmount;

}
