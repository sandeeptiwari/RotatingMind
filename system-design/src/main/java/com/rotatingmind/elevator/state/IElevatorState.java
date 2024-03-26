package com.rotatingmind.elevator.state;

import com.rotatingmind.elevator.data.Direction;
import com.rotatingmind.elevator.data.Floor;

public interface IElevatorState {

    void destine(Floor floor, Direction direction);
    void open(Floor floor);
    void close(Floor floor);
    void stop(Floor floor);

    State  getName();
}
