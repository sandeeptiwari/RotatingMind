package com.rotatingmind.battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BattleBoard implements Board {

    private int rowCount;
    private int columnCount;

    private final List<List<BattleBoardCell>> boardCells;

    public BattleBoard(int rowCount, int columnCount) {
        this.boardCells = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {

            List<BattleBoardCell> cells = new ArrayList<>();

            for (int j = 0; j < columnCount; j++) {
                BattleBoardCell cell = new BattleBoardCell(i, j);
                cells.add(cell);
            }
            boardCells.add(cells);
        }
    }

    @Override
    public void applyHit(Fire fire) {
        BattleBoardCell battleBoardCell = boardCells.get(fire.getDestination().getX())
                .get(fire.getDestination().getY());
        if (battleBoardCell.getShipPiece() != null && battleBoardCell.getShipPiece().isPresent()) {
            ShipPiece shipPiece = battleBoardCell.getShipPiece().get();
            shipPiece.setDead(true);
        }
    }

    @Override
    public void display() {

    }

    @Override
    public void putPiece(ShipPiece shipPiece) {
        boardCells.get(shipPiece.getPieceXPos())
                .get(shipPiece.getPieceYPos())
                .setShipPiece(Optional.of(shipPiece));
    }

    @Override
    public boolean isHit(Fire fire) {
        BattleBoardCell battleBoardCell = boardCells.get(fire.getDestination().getX())
                .get(fire.getDestination().getY());

        if (battleBoardCell.getShipPiece() != null && battleBoardCell.getShipPiece().isPresent()) {
            ShipPiece shipPiece = battleBoardCell.getShipPiece().get();
            ShipType type = shipPiece.getType();
            int count = shipPiece.getHitCount() + 1;
            shipPiece.setHitCount(count);

            if(shipPiece.getHitCount() <= 2 && type == ShipType.TWO_HIT_DESTROYABLE) {
                return true;
            } else if (shipPiece.getHitCount() == 1 && type == ShipType.SINGLE_HIT_DESTROYABLE) {
                return true;
            }
        }

        return  false;
    }
}
