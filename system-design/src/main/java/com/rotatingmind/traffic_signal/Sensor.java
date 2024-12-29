package com.rotatingmind.traffic_signal;

import lombok.Data;

enum SensorType {
    VEHICLE,
    PEDESTRIAN
}

@Data
public class Sensor {
    private final SensorType type;
    private final boolean isActive;

    public Sensor(SensorType type, boolean isActive) {
        this.type = type;
        this.isActive = isActive;
    }
}