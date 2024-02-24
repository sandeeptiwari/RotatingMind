package com.rotatingmind.battleship;


import java.util.ArrayDeque;
import java.util.Arrays;

public class BattleShipGame extends BoardGame  {

    private final Player player1;
    private final Player player2;

    public BattleShipGame(Board board1, Board board2, Player player1, Player player2) {
        super(board1, board2, new ArrayDeque<>(
                Arrays.asList(player1, player2)
        ));

        this.player1 = player1;
        this.player2 = player2;
        preparePlayer1Board(board1);
        preparePlayer2Board(board2);
    }

    private void preparePlayer1Board(Board board) {
        placePlayerShipOnBoard(player1, board);
    }

    private void preparePlayer2Board(Board board) {
        placePlayerShipOnBoard(player2, board);
    }

    private void placePlayerShipOnBoard(Player player, Board board) {
        player.getShips()
                .forEach(ship -> {
                    for (int j = 0; j < ship.getWidth(); j++) {
                        for (int k = 0; k < ship.getHight(); k++) {
                            ShipPiece shipPiece = new ShipPiece();
                            shipPiece.setPieceXPos(ship.getxPos() + j);
                            shipPiece.setPieceYPos(ship.getyPos() + k);
                            shipPiece.setType(ship.getType());
                            shipPiece.setDead(false);
                            board.putPiece(shipPiece);
                            ship.getShipPieces().add(shipPiece);
                        }
                    }
                });
    }

    @Override
    public boolean isOver() {
        boolean isPlayer1Alive = player1.getShips()
                .stream()
                .flatMap(ship -> ship.getShipPieces().stream())
                .allMatch(ShipPiece::isDead);

        boolean isPlayer2Alive = player2.getShips()
                .stream()
                .flatMap(ship -> ship.getShipPieces().stream())
                .allMatch(ShipPiece::isDead);

        return isPlayer1Alive || isPlayer2Alive;
    }
}
