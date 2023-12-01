package com.rotatingmind.chess;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class HumanChessPlayer extends ChessPlayer {


    public HumanChessPlayer(Map<PieceName, ChessPiece> pieces,
                            ChessBoard chessBoard,
                            String name) {
        super(name, chessBoard, pieces);
    }

    @Override
    public Move makeMove() {
        getChessBoard().display();
        int x, y;

        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();

        Optional<ChessPiece> chessPiece =
                getChessBoard().getCell(new Pair(x, y)).getChessPiece();

        if (!chessPiece.isPresent()) {
           throw new RuntimeException("Invalid spot");
        }

        if (!chessPiece.get().equals(getChessPiece(chessPiece.get().getName()))) {
            throw new RuntimeException("Invalid piece");
        }

        Pair source = new Pair(x, y);

        x = scanner.nextInt();
        y = scanner.nextInt();

        Pair destination = new Pair(x, y);

        return new Move(source, destination);
    }
}
