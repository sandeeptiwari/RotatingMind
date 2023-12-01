package com.rotatingmind.chess;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class ChessGame extends BoardGame {
    private final ChessPlayer player1;
    private final ChessPlayer player2;

    public ChessGame(ChessBoard board,
                     ChessPlayer player1,
                     ChessPlayer player2) {
        super(board, new ArrayDeque<>(
                Arrays.asList(player1, player2)
        ));
        this.player1 = player1;
        this.player2 = player2;
        prepareBoard(this.player1, this.player2, board);
    }

    private void prepareBoard(ChessPlayer firstPlayer,
                              ChessPlayer secondPlayer, ChessBoard board) {
        placePawns(1, board, firstPlayer);
        placePawns(6, board, secondPlayer);
        placeRooks(0, board, firstPlayer);
        placeRooks(7, board, secondPlayer);
        placeKnights(0, board, firstPlayer);
        placeKnights(7, board, secondPlayer);
        placeBishops(0, board, firstPlayer);
        placeBishops(7, board, secondPlayer);
        placeKing(0, board, firstPlayer);
        placeKing(7, board, secondPlayer);
        placeQueen(0, board, firstPlayer);
        placeQueen(7, board, secondPlayer);
    }

    @Override
    public boolean isOver() {
        return player1.getChessPiece(PieceName.KING).isDead()
                || player2.getChessPiece(PieceName.KING).isDead();
    }

    private void placePawns(int row, ChessBoard board, ChessPlayer player) {
        List<PieceName> pieceNames =
                Arrays.asList(PieceName.PAWN1,PieceName.PAWN2,PieceName.PAWN3, PieceName.PAWN4,
                        PieceName.PAWN5, PieceName.PAWN6, PieceName.PAWN7, PieceName.PAWN8);
        int col = 0;
        for (PieceName pieceName : pieceNames) {
            board.putPiece(player.getChessPiece(pieceName), row, col++);
        }
    }

    private void placeRooks(int row, ChessBoard board, ChessPlayer player) {
        board.putPiece(player.getChessPiece(PieceName.ROOK1), row, 0);
        board.putPiece(player.getChessPiece(PieceName.ROOK1), row, 7);
    }

    private void placeKnights(int row, ChessBoard board, ChessPlayer player) {
        board.putPiece(player.getChessPiece(PieceName.KNIGHT1), row, 1);
        board.putPiece(player.getChessPiece(PieceName.KNIGHT2), row, 6);
    }

    private void placeBishops(int row, ChessBoard board, ChessPlayer player) {
        board.putPiece(player.getChessPiece(PieceName.BISHOP1), row, 2);
        board.putPiece(player.getChessPiece(PieceName.BISHOP2), row, 5);
    }

    private void placeKing(int row, ChessBoard board, ChessPlayer player) {
        board.putPiece(player.getChessPiece(PieceName.KING), row, 3);
    }

    private void placeQueen(int row, ChessBoard board, ChessPlayer player) {
        board.putPiece(player.getChessPiece(PieceName.QUEEN), row, 4);
    }
}
