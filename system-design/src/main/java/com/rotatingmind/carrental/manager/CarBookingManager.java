package com.rotatingmind.carrental.manager;

import com.rotatingmind.carrental.domain.Booking;
import com.rotatingmind.carrental.domain.Car;
import com.rotatingmind.carrental.domain.enums.BookingStatus;
import com.rotatingmind.carrental.domain.enums.CarStatus;
import com.rotatingmind.carrental.manager.service.CarService;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;

public class CarBookingManager {
    private final CarService carService;

    public CarBookingManager() {
        this.carService = new CarService();
    }

    public String registerCarForRental(Car car) {
        return carService.addCar(car);
    }

    public String bookTheCar(Booking booking) {
        return carService.bookCar(booking);
    }

    public static void main(String[] args) {
        Car car1 = new Car.Builder()
                .setCarNo("12345")
                .setCarImage("Image1")
                .setId(1l)
                .setStatus(CarStatus.AVAILABLE)
                .setRatings(4)
                .build();
        Car car2 = new Car.Builder()
                .setCarNo("56789")
                .setCarImage("Image2")
                .setId(2l)
                .setStatus(CarStatus.AVAILABLE)
                .setRatings(4)
                .build();
        Car car3 = new Car.Builder()
                .setCarNo("01234")
                .setCarImage("Image3")
                .setId(3l)
                .setStatus(CarStatus.AVAILABLE)
                .setRatings(3)
                .build();

        CarBookingManager instance = new CarBookingManager();
        instance.registerCarForRental(car1);
        instance.registerCarForRental(car2);
        instance.registerCarForRental(car3);

        /**
         * year – the year to represent, from MIN_YEAR to MAX_YEAR
         * month – the month-of-year to represent, not null
         * dayOfMonth – the day-of-month to represent, from 1 to 31
         * hour – the hour-of-day to represent, from 0 to 23
         * minute – the minute-of-hour to represent, from 0 to 59
         */
        String respose = instance.bookTheCar(Booking.builder()
                .id(1l)
                .bookedAt(LocalDateTime.of(2023, Month.OCTOBER, 2, 10, 30))
                .bookingEndAt(LocalDateTime.of(2023, Month.OCTOBER, 4, 10, 30))
                .bookingStatus(BookingStatus.PENDING)
                .customerId(1l)
                .carId(2l)
                .build());
        System.out.println("Booking Status " + respose);

        String respose1 = instance.bookTheCar(Booking.builder()
                .id(1l)
                .bookedAt(LocalDateTime.of(2023, Month.OCTOBER, 2, 10, 30))
                .bookingEndAt(LocalDateTime.of(2023, Month.OCTOBER, 4, 10, 30))
                .bookingStatus(BookingStatus.PENDING)
                .customerId(1l)
                .carId(2l)
                .build());
        System.out.println("Booking Status " + respose1);
    }
}
