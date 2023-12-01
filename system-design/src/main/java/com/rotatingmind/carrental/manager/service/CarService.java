package com.rotatingmind.carrental.manager.service;

import com.rotatingmind.carrental.domain.Booking;
import com.rotatingmind.carrental.domain.Car;

import javax.annotation.concurrent.Immutable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Immutable
record BookingKey(Long id, LocalDateTime startDate, LocalDateTime endDate) {}

public class CarService {

    private Map<Long, Car>  carById = new HashMap<>();
    private Map<BookingKey, Booking>  bookingCarById = new HashMap<>();

    public String addCar(Car car) {
        carById.put(car.getId(), car);
        return "Car is added into inventory";
    }

    public Car searchCar(Long id) {
        return carById.getOrDefault(id, null);
    }

    public String bookCar(Booking request) {
        BookingKey key = new BookingKey(request.getCarId(), request.getBookedAt(), request.getBookingEndAt());
        Booking booking = bookingCarById.getOrDefault(key, null);
        if (booking != null) {
            return "Car is not available for this start and end time";
        }

        bookingCarById.put(key, request);

        return " Car number " + carById.get(request.getCarId()).getCarNo() + "is booked for booked for " +
                request.getBookedAt() + " To " + request.getBookingEndAt();
    }
}
