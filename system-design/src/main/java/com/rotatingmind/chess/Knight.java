package com.rotatingmind.chess;

public class Knight implements ChessPiece {
    private final Color color;

    private final PieceName pieceName;

    private boolean isDead;

    public Knight(PieceName pieceName, Color color, boolean isDead) {
        this.color = color;
        this.pieceName = pieceName;
        this.isDead = isDead;
    }

    @Override
    public void move(ChessCell source, ChessCell destination, ChessBoard chessBoard) {
        //move in L shape 2 move x/Y axis and 1 move perpendicular

        int xDiff = Math.abs(source.getX() - destination.getX());
        int yDiff = Math.abs(source.getY() - destination.getY());

        //illegal move
        if (!(Math.max(xDiff, yDiff) == 2 && Math.min(xDiff, yDiff) == 1)) {
            throw new RuntimeException("Invalid Move");
        }

        if (destination.getChessPiece().isPresent()) {
            if (destination.getChessPiece().get().getColor().equals(getColor())) {
                throw new RuntimeException("Invalid destination contains own piece");
            } else {
                destination.getChessPiece().get().setDead(true);
            }
        }

        chessBoard.movePiece(source.getX(), source.getY());
        chessBoard.putPiece(this, destination.getX(), destination.getY());
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
        return color;
    }
}
