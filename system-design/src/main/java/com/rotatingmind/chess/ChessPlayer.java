package com.rotatingmind.chess;

import java.util.Map;

public abstract class ChessPlayer extends Player {
    private final ChessBoard chessBoard;

    private final Map<PieceName, ChessPiece> chessPieces;

    public ChessPlayer(String name, ChessBoard chessBoard,
                       Map<PieceName, ChessPiece> chessPieces) {
        super(name);
        this.chessBoard = chessBoard;
        this.chessPieces = chessPieces;
    }

    @Override
    public Move makeMove() {
        return null;
    }

    public ChessPiece getChessPiece(PieceName chessPieceName) {
        if (!chessPieces.containsKey(chessPieceName))
            throw new IllegalArgumentException("Invalid Argument.");

        return chessPieces.get(chessPieceName);
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public Map<PieceName, ChessPiece> getChessPieces() {
        return chessPieces;
    }
}
