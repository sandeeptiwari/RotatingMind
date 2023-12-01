package com.rotatingmind.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChessBoard implements Board {
    private static final int CHESSBOARD_ROW_COUNT = 8;
    private static final int CHESSBOARD_COLUMN_COUNT = 8;
    private final List<List<ChessCell>> cells;

    public ChessBoard() {
        this.cells = new ArrayList<>();

        for (int i = 0; i < CHESSBOARD_ROW_COUNT; i++) {
            List<ChessCell> chessCells = new ArrayList<>();
            for (int j = 0; j < CHESSBOARD_COLUMN_COUNT; j++) {
                ChessCell cell = new ChessCell(i, j);
                chessCells.add(cell);
            }
            cells.add(chessCells);
        }

    }

    @Override
    public void applyMove(Move move) {
        ChessCell sourceCell = getCell(move.getSource());
        ChessCell destinationCell = getCell(move.getDestination());
        Optional<ChessPiece> chessPiece = sourceCell.getChessPiece();
        ChessPiece chessPiece1 = chessPiece.get();
        chessPiece1.move(sourceCell, destinationCell, this);
    }

    @Override
    public void display() {
        for (int i = 0; i < CHESSBOARD_ROW_COUNT; i++) {
            for (int j = 0; j < CHESSBOARD_COLUMN_COUNT; j++) {
                Pair pair = new Pair(i, j);
                Optional<ChessPiece> chessPiece = getCell(pair).getChessPiece();

                if (!chessPiece.isPresent()) {
                    System.out.println("0 | ");
                } else {
                    System.out.println(chessPiece.get().getName() + " | ");
                }
            }
            System.out.println("");
        }
    }

    public ChessCell getCell(Pair pair) {
        return  this.cells.get(pair.getX()).get(pair.getY());
    }

    public void putPiece(ChessPiece chessPiece, int row, int col) {
        cells.get(row).get(col).setChessPiece(Optional.of(chessPiece));
    }

    public void movePiece(int row, int col) {
        cells.get(row).get(col).setChessPiece(Optional.empty());
    }
}
