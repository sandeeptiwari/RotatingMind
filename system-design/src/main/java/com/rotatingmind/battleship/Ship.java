package com.rotatingmind.battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final ShipType type;

    private boolean isDestroyed;

    private final int xPos;

    private final int yPos;

    private final int width;
    private final int hight;

    private final List<ShipPiece> shipPieces;

    public Ship(ShipType type, int xPos, int yPos, int width, int hight) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.hight = hight;
        this.type = type;
        shipPieces = new ArrayList<>();
    }

    public ShipType getType() {
        return type;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }

    public List<ShipPiece> getShipPieces() {
        return shipPieces;
    }
}
