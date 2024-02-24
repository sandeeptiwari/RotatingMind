package com.rotatingmind.elevator.move;

import com.rotatingmind.elevator.data.Direction;
import com.rotatingmind.elevator.data.Move;

import java.util.Optional;

public interface MoveStore {

    void addMove(Move move);

    Optional<Move> getTop();

    void clearTop();

    Direction getCurrentDirection();
}
