package com.rotatingmind.tictactoe.model;

public class Result {

    private final IPlayer winner;

    public Result(IPlayer currentPlayer) {
        this.winner = currentPlayer;
    }

    public IPlayer getWinner() {
        return winner;
    }

    public boolean isDraw() {
        return winner == null;
    }
}
