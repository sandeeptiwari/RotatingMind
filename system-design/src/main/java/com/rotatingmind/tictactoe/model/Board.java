package com.rotatingmind.tictactoe.model;

public class Board {
    private String[][] cells;

    public Board() {
        cells = new String[3][3];

        for(int i = 0; i < 3; i++) {

            for(int j = 0; j < 3; j++) {
                cells[i][j] = " ";
            }
        }
    }


    public boolean isFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (cells[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void applyMove(Move currentMove, Symbol symbol) {
        cells[currentMove.getMoveX()][currentMove.getMoveY()] = symbol.getName();
    }

    public boolean isGameOver(IPlayer currentPlayer) {
        return hasHorizontalWin(currentPlayer.getSymbol().getName()) ||
                hasVerticalWin(currentPlayer.getSymbol().getName()) ||
                hasDiagonalWin(currentPlayer.getSymbol().getName());
    }

    private boolean hasDiagonalWin(String symbol) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][i].equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVerticalWin(String symbol) {

        for (int i = 0; i < 3; i++) {
            if (cells[0][i].equals(symbol) && cells[1][i].equals(symbol) && cells[2][i].equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasHorizontalWin(String symbol) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0].equals(symbol) && cells[i][1].equals(symbol) && cells[i][2].equals(symbol)) {
                return true;
            }
        }
        return false;
    }


}
