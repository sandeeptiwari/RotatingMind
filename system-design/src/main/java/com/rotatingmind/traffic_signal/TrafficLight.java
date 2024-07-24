package com.rotatingmind.traffic_signal;

import lombok.Data;

@Data
public class TrafficLight {
    private final String id;
    private TrafficLightState state;;
    private double duration;

    public TrafficLight(String id, TrafficLightState state, double duration) {
        this.id = id;
        this.state = state;
        this.duration = duration;
    }



    /*public void changeState() {
        switch (currentState) {
            case RED:
                currentState = TrafficLightState.GREEN;
                break;
            case GREEN:
                currentState = TrafficLightState.YELLOW;
                break;
            case YELLOW:
                currentState = TrafficLightState.RED;
                break;
        }
    }*/

}
