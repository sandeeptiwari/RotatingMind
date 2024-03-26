package com.rotatingmind.ioc.manager;

import com.rotatingmind.ioc.data.Game;

public class GameManagerV1 {

    private final Game game;

    public GameManagerV1(Game game) {
        this.game = game;
    }

    public void manage() {
        game.init();
        game.start();
        game.finish();
    }
}
