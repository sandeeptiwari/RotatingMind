package com.rotatingmind.elevator.state;

import com.rotatingmind.elevator.core.Elevator;
import com.rotatingmind.elevator.data.Direction;
import com.rotatingmind.elevator.data.Floor;
import com.rotatingmind.elevator.data.Move;

public class IdleState implements IElevatorState {
    private final Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destine(Floor floor, Direction direction) {
        this.elevator.getMoveStore().addMove(new Move(floor, direction));
        Direction topDirection =
                this.elevator.getMoveStore().getTop().get().getDestinationDirection();
        if (topDirection.equals(Direction.UP)) {
            this.elevator.setState(new MovingUpState(this.elevator));
        } else {
            this.elevator.setState(new MovingDownState(this.elevator));
        }
        // more checks
    }

    @Override
    public void open(Floor floor) {
        // some code
        this.elevator.setState(new GateOpenState(this.elevator));
    }

    @Override
    public void close(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void stop(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public State getName() {
        return State.IDLE;
    }
}