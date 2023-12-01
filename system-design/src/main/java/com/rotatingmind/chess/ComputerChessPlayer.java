package com.rotatingmind.chess;

import java.util.Map;
import java.util.Scanner;

public class ComputerChessPlayer extends ChessPlayer {

    public ComputerChessPlayer(Map<PieceName, ChessPiece> pieces,
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

        return super.makeMove();
    }
}
