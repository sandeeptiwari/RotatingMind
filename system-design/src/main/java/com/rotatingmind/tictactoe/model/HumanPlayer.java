package com.rotatingmind.tictactoe.model;

import java.util.Scanner;

public class HumanPlayer implements IPlayer {

    private final String name;
    private final Symbol symbol;

    public HumanPlayer(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public Move play() {
        System.out.println("fetching move from console...");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        return new Move(x, y);
    }
}
