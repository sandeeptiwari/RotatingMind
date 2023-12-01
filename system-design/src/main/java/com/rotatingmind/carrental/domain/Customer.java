package com.rotatingmind.carrental.domain;

import lombok.Builder;
import lombok.Data;

@Builder
public class Customer extends User {
   private String drivingLicence;
}
