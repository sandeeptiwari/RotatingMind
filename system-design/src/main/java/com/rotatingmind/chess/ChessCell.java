package com.rotatingmind.chess;

import lombok.Getter;

import java.util.Optional;

public class ChessCell {
    private final int x;
    private final int y;

    @Getter
    private Optional<ChessPiece> chessPiece;

    public ChessCell(int x, int y) {
        this.x = x;
        this.y = y;
        chessPiece = Optional.empty();
    }

    public void setChessPiece(Optional<ChessPiece> chessPiece) {
        this.chessPiece = chessPiece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
