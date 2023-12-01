package com.rotatingmind.chess;

import java.util.Queue;

public abstract class BoardGame {

    private final Board board;

    private final Queue<Player> players;

    public BoardGame(Board board, Queue<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void start() {
        while(true) {
            Player currentPlayer = players.poll();
            Move move = currentPlayer.makeMove();
            board.applyMove(move);
            if (isOver()) {
                System.out.println("Game is over " + currentPlayer.getName() + " won.");
                break;
            }
            players.add(currentPlayer);
        }
    }

    public abstract boolean isOver();
}
