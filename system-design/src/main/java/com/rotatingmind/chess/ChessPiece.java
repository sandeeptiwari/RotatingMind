package com.rotatingmind.chess;

enum PieceName {
    KING,
    QUEEN,

    PAWN1,
    PAWN2,
    PAWN3,
    PAWN4,
    PAWN5,
    PAWN6,
    PAWN7,
    PAWN8,

    ROOK1,

    ROOK2,

    KNIGHT1,

    KNIGHT2,

    BISHOP1,

    BISHOP2

}
public interface ChessPiece {

    void move(ChessCell source, ChessCell destination, ChessBoard chessBoard);

    boolean isDead();


    void setDead(boolean dead);

    PieceName getName();

    Color getColor();


}
