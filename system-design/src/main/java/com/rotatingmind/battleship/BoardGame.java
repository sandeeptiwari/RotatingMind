package com.rotatingmind.battleship;

import java.util.Optional;
import java.util.Queue;

public abstract class BoardGame {

    private final Board player1Board;
    private final Board player2Board;

    private final Queue<Player> players;

    /**
     * A1 B2 B2 B3
     * A1 B2 B3 A1 D1 E1 D4 D4 D5 D5
     * @param players
     */

    public BoardGame(Board player1Board, Board player2Board, Queue<Player> players) {
        this.player1Board = player1Board;
        this.player2Board = player2Board;
        this.players = players;
    }

    public void start() {
        Player currentPlayer = players.poll();
        int num = 20;
        while(num >= 0) {
            Optional<Fire> fire = currentPlayer.launchMissile();
            if (currentPlayer.getName().equalsIgnoreCase("player1")) {
                if (fire.isPresent()) {
                    if(!player2Board.isHit(fire.get())) {
                        System.out.println("Player-1 fires a missile with target (" + fire.get().getDestination().getX() + ", " +fire.get().getDestination().getY()  + ") which got miss");
                        players.add(currentPlayer);
                        currentPlayer = players.poll();
                    } else {
                        player2Board.applyHit(fire.get());
                        System.out.println("Player-1 fires a missile with target (" + fire.get().getDestination().getX() + ", " +fire.get().getDestination().getY()  + ") which got hit");
                    }
                } else {
                    System.out.println("Player-1 has no more missiles left to launch");
                    players.add(currentPlayer);
                    currentPlayer = players.poll();
                }

            } else {
                if (fire.isPresent()) {
                    if (!player1Board.isHit(fire.get())) {
                        System.out.println("Player-2 fires a missile with target (" + fire.get().getDestination().getX() + ", " + fire.get().getDestination().getY() + ") which got miss");
                        players.add(currentPlayer);
                        currentPlayer = players.poll();
                    } else {
                        System.out.println("Player-2 fires a missile with target (" + fire.get().getDestination().getX() + ", " + fire.get().getDestination().getY() + ") which got hit");
                        player1Board.applyHit(fire.get());
                    }
                } else {
                    System.out.println("Player-2 has no more missiles left to launch");
                    players.add(currentPlayer);
                    currentPlayer = players.poll();
                }
            }

            if (isOver()) {
                System.out.println("Game is over " + currentPlayer.getName() + " won.");
                break;
            }
          num--;
        }
    }

    public abstract boolean isOver();
}
