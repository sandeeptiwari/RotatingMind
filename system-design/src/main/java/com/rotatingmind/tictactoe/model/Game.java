package com.rotatingmind.tictactoe.model;

public class Game {

    private final HumanPlayer one;
    private final HumanPlayer two;

    private final Board board;

    public Game(HumanPlayer one, HumanPlayer two, Board board) {

        this.one = one;
        this.two = two;
        this.board = board;
    }


}
