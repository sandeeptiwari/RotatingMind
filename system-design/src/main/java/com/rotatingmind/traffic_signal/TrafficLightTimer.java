package com.rotatingmind.traffic_signal;

import java.util.Timer;
import java.util.TimerTask;

public class TrafficLightTimer {
    private final TrafficController controller;
    private Timer timer;

    public TrafficLightTimer(TrafficController controller) {
        this.controller = controller;
    }

   /* public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                controller.changeTrafficLightStates();
                displayTrafficLightStates();
            }
        }, 0, 1000); // Change state every second for demonstration
    }

    public void displayTrafficLightStates() {
        for (TrafficLight trafficLight : controller.getTrafficLights()) {
            System.out.println("Traffic Light " + trafficLight.getId() + " is " + trafficLight.getCurrentState());
        }
    }

    public void stop() {
        timer.cancel();
    }*/

}
