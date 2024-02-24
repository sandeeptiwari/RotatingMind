package com.rotatingmind.battleship;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Deque;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@Setter
@Getter
public class Player {
    private BattleBoard battleBoard;

    private final List<Ship> ships;

    private int numberOfShip;

    private final String name;

    private Deque<Pair> fires;

    public Optional<Fire> launchMissile() {
        if (!fires.isEmpty()) {
            Pair destination = fires.removeFirst();
            return Optional.of(new Fire(destination));
        }
        return Optional.empty();
    }

}
