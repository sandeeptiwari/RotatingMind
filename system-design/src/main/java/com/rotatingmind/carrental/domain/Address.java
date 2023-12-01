package com.rotatingmind.carrental.domain;

import lombok.Data;

@Data
public class Address {
    private Long id;

    private String addressLine1;

    private String addressLine2;

    private String country;

    private String state;

    private String  city;

    private String pinCode;
}
