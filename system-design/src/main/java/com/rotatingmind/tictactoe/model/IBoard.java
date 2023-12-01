package com.rotatingmind.tictactoe.model;

public interface IBoard {
    void applyMove(Move move);

    boolean isMoveValid(Move move);

    boolean isGameOver();

    boolean isDraw();

    boolean hasWinningLine(String symbol);

    int getDimension();
}
