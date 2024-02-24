package com.rotatingmind.elevator.state;

import com.rotatingmind.elevator.core.Elevator;
import com.rotatingmind.elevator.data.Direction;
import com.rotatingmind.elevator.data.Floor;
import com.rotatingmind.elevator.data.Move;

public class MovingUpState implements IElevatorState {
    private final Elevator elevator;

    public MovingUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destine(Floor floor, Direction direction) {
        this.elevator.getMoveStore().addMove(new Move(floor,direction));
        Direction topDirection = this.elevator.getMoveStore().getTop().get()
                .getDestinationDirection();
        if (topDirection.equals(Direction.DOWN))
            this.elevator.setState(new MovingDownState(this.elevator));
    }

    @Override
    public void open(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void close(Floor floor) {
        throw new RuntimeException();
    }

    @Override
    public void stop(Floor floor) {
        // more code
        this.elevator.getMoveStore().clearTop();
        this.elevator.setState(new IdleState(this.elevator));
    }

    @Override
    public State getName() {
        return State.MOVING_UP;
    }
}
