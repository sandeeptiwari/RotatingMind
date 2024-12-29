package com.rotatingmind.tictactoe;

import com.rotatingmind.tictactoe.model.Board;
import com.rotatingmind.tictactoe.model.ComputerPlayer;
import com.rotatingmind.tictactoe.model.HumanPlayer;
import com.rotatingmind.tictactoe.model.IPlayer;
import com.rotatingmind.tictactoe.model.Move;
import com.rotatingmind.tictactoe.model.Result;
import com.rotatingmind.tictactoe.model.Symbol;

public class TicTacToe {

    public Result play(IPlayer player1, IPlayer player2) {

        IPlayer currentPlayer = player1;

        Board board = new Board();

        while(!board.isFull()) {

            Move currentMove = currentPlayer.play();
            // update board
            board.applyMove(currentMove, currentPlayer.getSymbol());
            // check if game is over
            // else, switch player
            if(board.isGameOver(currentPlayer)) {
                return new Result(currentPlayer);
            } else {
                currentPlayer = currentPlayer == player1 ? player2 : player1;
            }
        }

        return new Result(null);
    }


    public static void main(String[] args) {

        IPlayer player1 = new HumanPlayer("Player 1", new Symbol("X"));
        IPlayer player2 = new ComputerPlayer("Player 2", new Symbol("O"));

        TicTacToe ticTacToe = new TicTacToe();
        Result result = ticTacToe.play(player1, player2);

        if (!result.isDraw()) {
            System.out.println("Game over " + result.getWinner().getSymbol().getName() + " wins");
        } else {
            System.out.println("Game over, no one wins");
        }
    }
}
