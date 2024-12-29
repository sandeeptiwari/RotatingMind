package com.rotatingmind.practice.parkinglot;



import com.rotatingmind.practice.parkinglot.domain.Ticket;
import com.rotatingmind.practice.parkinglot.domain.Vehicle;
import com.rotatingmind.practice.parkinglot.domain.VehicleType;
import com.rotatingmind.practice.parkinglot.manager.ParkingManager;
import com.rotatingmind.practice.parkinglot.parking.ParkingFloor;
import com.rotatingmind.practice.parkinglot.parking.ParkingLot;
import com.rotatingmind.practice.parkinglot.parking.ParkingSystem;

import java.util.HashMap;
import java.util.Map;

/** findParkingSpotAPI
 *    - entryPoint
 *    - VehicleType
 *    - spot selection strategy
 *   ==> spot
 *
 * GetTicket API
 *  - vehicle
 *  - parking lot
 * ==> ticket
 *
 * PayParkingFeesAPI
 *  - Ticket
 *  - PaymentDetails
 *
 * VacateParkingSpotAPI
 */
public class Tester {

    public static void main(String[] args) {
        Map<String, ParkingFloor> floors = new HashMap<>();

        floors.put("Aqua", new ParkingFloor("Aqua", 7));
        floors.put("Magenta", new ParkingFloor("Magenta", 7));

        ParkingManager parkingManager =  new ParkingManager(ParkingLot.getInstance("SkyParking", floors));
        ParkingSystem parkingSystem = new ParkingSystem(parkingManager);

        try {
            // parking a van 4 wheeler
            System.out.println("\n\n");
            Ticket parkingTicket1 = parkingSystem.parkVehicle(new Vehicle("TATA_VAN", VehicleType.FOUR_WHEELER, "003-BOSS"));
            Ticket parkingTicket2 = parkingSystem.parkVehicle(new Vehicle("SWIFT_DESIRE", VehicleType.FOUR_WHEELER, "123-333"));
            Ticket parkingTicket3 = parkingSystem.parkVehicle(new Vehicle("TRUCK", VehicleType.HEAVY, "ANCVV"));
            Ticket parkingTicket4 = parkingSystem.parkVehicle(new Vehicle("AULTO", VehicleType.FOUR_WHEELER, "ZZZ-099"));

            System.out.println("\n\n");
            System.out.println("Parking ticket: " + parkingTicket1);
            System.out.println("Parking ticket: " + parkingTicket2);
            System.out.println("Parking ticket: " + parkingTicket3);
            System.out.println("Parking ticket: " + parkingTicket4);

            // drivers un-park their vehicles via ParkingSystem
            System.out.println("\n\n");

            System.out.println("Un-parking done: " + parkingSystem.unParkVehicle(parkingTicket1));
            System.out.println("Un-parking done: " + parkingSystem.unParkVehicle(parkingTicket2));
            System.out.println("Un-parking done: " + parkingSystem.unParkVehicle(parkingTicket3));
            System.out.println("Un-parking done: " + parkingSystem.unParkVehicle(parkingTicket4));


            System.out.println("\n\n");
            System.out.println("Parking ticket: " + parkingTicket1);
            System.out.println("Parking ticket: " + parkingTicket2);
            System.out.println("Parking ticket: " + parkingTicket3);
            System.out.println("Parking ticket: " + parkingTicket4);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }
}
