package com.rotatingmind.traffic_signal;

import lombok.Data;

@Data
public class PedestrianSignal {
    private PedestrianSignalState state;
    private int duration; // in seconds

    public PedestrianSignal(PedestrianSignalState state, int duration) {
        this.state = state;
        this.duration = duration;
    }
}
