package com.rotatingmind.traffic_signal;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Tester {

    public static void main(String[] args) {
        TrafficLight eastTrafficLight = new TrafficLight("ETL", TrafficLightState.RED, 5);
        TrafficLight westTrafficLight = new TrafficLight("WTL", TrafficLightState.RED, 5);
        TrafficLight northTrafficLight = new TrafficLight("NTL", TrafficLightState.RED, 5);
        TrafficLight southTrafficLight = new TrafficLight("STL", TrafficLightState.RED, 5);

        PedestrianSignal pedestrianSignal = new PedestrianSignal(PedestrianSignalState.DONT_WALK, 30);

        TrafficController controller = new TrafficController(
                List.of(
                        eastTrafficLight,
                        westTrafficLight,
                        northTrafficLight,
                        southTrafficLight),
                Optional.of(Collections.emptyList()));

        controller.start();

        // Simulate the system running
        while (true) {
            controller.update();
            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
