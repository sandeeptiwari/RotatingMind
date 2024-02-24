package com.rotatingmind.battleship;


import lombok.Data;

@Data
public class ShipPiece {

    private ShipType type;
    private boolean isDead;

    private int hitCount;

    private int pieceXPos;
    private int pieceYPos;

}
