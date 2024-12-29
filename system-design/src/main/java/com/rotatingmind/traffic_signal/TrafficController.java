package com.rotatingmind.traffic_signal;

import java.util.List;
import java.util.Optional;

public class TrafficController {
    private final List<TrafficLight> trafficLights;
    private final Optional<List<PedestrianSignal>> pedestrianSignals; // Optional
    private int currentTime;
    private boolean isEmergency;

    public TrafficController(List<TrafficLight> trafficLights, Optional<List<PedestrianSignal>> pedestrianSignals) {
        this.trafficLights = trafficLights;
        this.pedestrianSignals = pedestrianSignals;
    }

    public void start() {
        // Logic to start the traffic light system
        this.currentTime = 0;
        this.isEmergency = false;
        System.out.println("Traffic light system started.");
    }

    public void stop() {
        // Logic to stop the traffic light system
        this.isEmergency = true;
        System.out.println("Traffic light system stopped.");
    }

    public void reset() {
        // Logic to reset the traffic light system
        this.currentTime = 0;
        trafficLights.forEach(state -> state.setState(TrafficLightState.RED));
        pedestrianSignals.ifPresent(signal -> signal.forEach(state -> state.setState(PedestrianSignalState.DONT_WALK)));
        System.out.println("Traffic light system reset.");
    }

    public void triggerEmergencyMode() {
        this.isEmergency = true;
        // Logic to set all lights to red
        this.isEmergency = true;
        trafficLights.forEach(state -> state.setState(TrafficLightState.RED));
        pedestrianSignals.ifPresent(signal -> signal.forEach(state -> state.setState(PedestrianSignalState.DONT_WALK)));
        System.out.println("Emergency mode activated: All lights are red.");
    }

    public void clearEmergencyMode() {
        this.isEmergency = false;
        // Logic to resume normal operation
        this.isEmergency = false;
        System.out.println("Emergency mode deactivated: Resuming normal operation.");
    }

    public void update() {
        // Logic to update the current time and handle state transitions
        if (isEmergency) {
            return;
        }
        currentTime++;

        trafficLights.forEach(signal -> {

            switch (signal.getState()) {
                case GREEN -> {
                    System.out.println("Inside GREEN Current signal is " + signal.getId());
                    if(currentTime >= signal.getDuration()) {
                        signal.setState(TrafficLightState.YELLOW);
                        currentTime = 0;
                        System.out.println( signal.getId() + " light changed to " + signal.getState().name() + "...........");
                    }
                }
                case RED -> {
                    System.out.println("Inside RED Current signal is " + signal.getId() );
                    if(currentTime >= signal.getDuration()) {
                        signal.setState(TrafficLightState.GREEN);
                        currentTime = 0;
                        System.out.println( signal.getId() + " light changed to " + signal.getState().name() + "...........");
                    }
                }
                case YELLOW -> {
                    System.out.println("Inside YELLOW Current signal is " + signal.getId());
                    if(currentTime >= signal.getDuration()) {
                        signal.setState(TrafficLightState.RED);
                        currentTime = 0;
                        System.out.println( signal.getId() + " light changed to " + signal.getState().name() + "...........");
                    }
                }
            }

        });
    }

}
