package com.rotatingmind.designpattern.decorator.seatbooking;

public class MainCabinSeat implements FlightSeat {

    @Override
    public String getFacilities() {
        return "Main cabin seat";
    }

    @Override
    public Double getCost() {
        return 500.0;
    }

    public static void main(String[] args) {
        FlightSeat mainCabinSeat = new Wifi(new HeadPhone(new LiveTv(new MainCabinSeat())));

        System.out.println("Chosen Facilities for your seat:");
        System.out.println(mainCabinSeat.getFacilities());
        System.out.println("Total Cost:" + mainCabinSeat.getCost());
    }
}
