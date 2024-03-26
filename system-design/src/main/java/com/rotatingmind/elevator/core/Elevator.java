package com.rotatingmind.elevator.core;

import com.rotatingmind.elevator.data.Direction;
import com.rotatingmind.elevator.data.Floor;
import com.rotatingmind.elevator.move.MoveStore;
import com.rotatingmind.elevator.state.IElevatorState;

public class Elevator {

    private Floor currentFloor;
    private IElevatorState state;

    public MoveStore getMoveStore() {
        return moveStore;
    }

    private final MoveStore moveStore;

    public Elevator(MoveStore moveStore) {
        this.moveStore = moveStore;
    }

    public void destine(Floor floor, Direction direction) {
        this.state.destine(floor, direction);
    }

    public void open(Floor floor) {
        this.state.open(floor);
    }

    public void close(Floor floor) {
        this.state.close(floor);
    }

    public void stop(Floor floor) {
        this.state.stop(floor);
    }


    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public IElevatorState getState() {
        return state;
    }

    public void setState(IElevatorState state) {
        this.state = state;
    }

}
