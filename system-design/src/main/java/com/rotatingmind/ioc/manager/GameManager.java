package com.rotatingmind.ioc.manager;

import com.rotatingmind.ioc.data.Chess;
import com.rotatingmind.ioc.data.Game;
import com.rotatingmind.ioc.data.GameType;
import com.rotatingmind.ioc.data.TicTacToe;

public class GameManager {



    void manage(GameType gameType) {
        Game game = null;

        if (gameType.equals(GameType.CHESS)) {
            game = new Chess();
        } else if (gameType.equals(GameType.Tic_Tac_Toe))  {
            game = new TicTacToe();
        }
    }
}
