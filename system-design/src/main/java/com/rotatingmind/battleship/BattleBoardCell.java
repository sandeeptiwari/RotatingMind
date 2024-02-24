package com.rotatingmind.battleship;

import java.util.Optional;

public class BattleBoardCell {

    private final int x;
    private final int y;

    private int hitCount;

    private Optional<ShipPiece> shipPiece;

    public BattleBoardCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setShipPiece(Optional<ShipPiece> shipPiece) {
        this.shipPiece = shipPiece;
    }

    public Optional<ShipPiece> getShipPiece() {
        return shipPiece;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
}
