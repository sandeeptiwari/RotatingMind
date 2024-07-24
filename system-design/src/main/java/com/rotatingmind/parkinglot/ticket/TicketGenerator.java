package com.rotatingmind.parkinglot.ticket;


import com.rotatingmind.parkinglot.data.ParkingSpot;
import com.rotatingmind.parkinglot.data.Ticket;
import com.rotatingmind.parkinglot.data.Vehicle;

public class TicketGenerator {


    public Ticket generateTicket(Vehicle vehicle,
                                 ParkingSpot parkingSpot) {
        String ticketNum = getUniqueTicketNum();
        // logic to check if isFree & then park & persist in DB
        //we have to think context switching also
        return new Ticket(ticketNum, vehicle, parkingSpot);
    }

    private String getUniqueTicketNum() {
        return "";
    }

}
