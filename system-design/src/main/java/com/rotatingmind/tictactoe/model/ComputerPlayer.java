package com.rotatingmind.tictactoe.model;

public class ComputerPlayer implements IPlayer {

        private final Symbol symbol;

        private final String name;

        public ComputerPlayer(String name, Symbol symbol) {
            this.symbol = symbol;
            this.name = name;
        }

        @Override
        public Move play() {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            return new Move(x, y);
        }

        @Override
        public Symbol getSymbol() {
            return symbol;
        }
}
