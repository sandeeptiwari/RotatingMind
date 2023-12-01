package com.rotatingmind.tictactoe.model;

public class Move {

    private final int moveX;

    private final int moveY;

    public Move(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public int getMoveX() {
        return moveX;
    }

    public int getMoveY() {
        return moveY;
    }
}
