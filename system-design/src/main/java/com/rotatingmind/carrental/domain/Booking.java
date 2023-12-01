package com.rotatingmind.carrental.domain;

import com.rotatingmind.carrental.domain.enums.BookingStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class Booking {
    private Long id;

    private BookingStatus bookingStatus;

    private Long carId;

    private Long customerId;

    private Address pickupLocation;

    private Address dropLocation;

    private LocalDateTime bookedAt;

    private LocalDateTime bookingEndAt;
}
