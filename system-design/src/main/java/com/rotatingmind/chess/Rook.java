package com.rotatingmind.chess;

public class Rook implements ChessPiece {
    private final Color color;

    private final PieceName pieceName;

    private boolean isDead;

    public Rook(PieceName pieceName, Color color, boolean isDead) {
        this.color = color;
        this.pieceName = pieceName;
        this.isDead = isDead;
    }

    @Override
    public void move(ChessCell source, ChessCell destination, ChessBoard chessBoard) {

    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public PieceName getName() {
        return pieceName;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
