package com.rotatingmind.practice.parkinglot.parking;


import com.rotatingmind.practice.parkinglot.domain.Ticket;
import com.rotatingmind.practice.parkinglot.domain.Vehicle;

public interface Parking {

    Ticket parkVehicle(Vehicle vehicle) throws IllegalAccessException;

    Boolean unParkVehicle(Ticket ticket) throws PaymentFailedException;
}
