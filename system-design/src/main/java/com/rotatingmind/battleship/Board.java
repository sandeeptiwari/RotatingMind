package com.rotatingmind.battleship;

public interface Board {

    void applyHit(Fire fire);

    void display();

    void putPiece(ShipPiece shipPiece);


    boolean isHit(Fire fire);

}
