package com.rotatingmind.battleship;

import java.util.*;
import java.util.stream.Stream;

public class Tester {

    static Map<Character, Integer> alphabetMap = new HashMap<>();

    public static void main(String[] args) {

        // Populating the Map with English letters and their positions
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            int position = i ;
            alphabetMap.put(letter, position);
        }

        Scanner sc = new Scanner(System.in);
        String battleFieldDim = "5 E";//sc.nextLine();


        String[] dims = battleFieldDim.split(" ");
        int col = alphabetMap.get(dims[1].trim().charAt(0)) + 1;
        int row = Integer.parseInt(dims[0].trim());
        //build board
        BattleBoard board = new BattleBoard(row, col);

        BattleBoard board1 = new BattleBoard(row, col);


        //number of battleShip for each player
        int noOfShips = 2;//sc.nextInt();

        //The third line of the input contains the type of the battleship, its dimensions (width and height) and coordinates for
        //Player-1 and Player-2.
        //Q 1 1 A1 B2
        Map<String, List<Ship>> shipByPlayer = new HashMap<>();
        List<Ship> player1Ships = new ArrayList<>();
        List<Ship> player2Ships = new ArrayList<>();

        String[] arr = {"Q 1 1 A1 B2", "P 2 1 D4 C3"};

        for (int i = 0; i < noOfShips; i++) {
            String battleShipDetail = arr[i];//sc.nextLine();

            //if (battleShipDetail.trim().length() == 0)
                //battleShipDetail = sc.nextLine();

            String[] details = battleShipDetail.split(" ");

            ShipType shipType = ShipType.getByName(details[0].trim());
            int width = Integer.parseInt(details[1].trim());
            int hight = Integer.parseInt(details[2].trim());

            //ship pos
            String xPosStr = details[3].trim();
            String yPosStr = details[4].trim();

            int xPos = Integer.parseInt(xPosStr.trim().charAt(1)+"") - 1;
            int yPos = alphabetMap.get(xPosStr.charAt(0));

            int xPos1 = Integer.parseInt(yPosStr.trim().charAt(1)+"") - 1;
            int yPos1 = alphabetMap.get(yPosStr.charAt(0));

            Ship ship = new Ship(shipType, xPos, yPos, width, hight);
            //add into player1 List
            player1Ships.add(ship);

            Ship ship1 = new Ship(shipType, xPos1, yPos1, width, hight);
            //add into player2 List
            player2Ships.add(ship1);
        }


        String player1FiresStr = "A1 B2 B2 B3";//sc.nextLine();
        String[] player1Fires = player1FiresStr.split(" ");

        String player2FiresStr = "A1 B2 B3 A1 D1 E1 D4 D4 D5 D5";//sc.nextLine();
        String[] player2Fires = player2FiresStr.split(" ");

        List<Pair> player1MissileFireLocations = Stream.of(player1Fires)
                .map(ele -> {
                    int xPos = Integer.parseInt(ele.trim().charAt(1) + "") - 1;
                    int yPos = alphabetMap.get(ele.trim().charAt(0));;
                    return new Pair(xPos, yPos);
                }).toList();

        List<Pair> player2MissileFireLocations = Stream.of(player2Fires)
                .map(ele -> {
                    int xPos = Integer.parseInt(ele.trim().charAt(1) + "") -1;
                    int yPos = alphabetMap.get(ele.trim().charAt(0));
                    return new Pair(xPos, yPos);
                }).toList();

        Player player1 = Player.builder()
                .name("Player1")
                .numberOfShip(noOfShips)
                .ships(player1Ships)
                .fires(new LinkedList<>(player1MissileFireLocations))
                .build();


        Player player2 = Player.builder()
                .name("Player2")
                .numberOfShip(noOfShips)
                .ships(player2Ships)
                .fires(new LinkedList<>(player2MissileFireLocations))
                .build();

        Queue<Player> playerQueue = new ArrayDeque<>();
        playerQueue.add(player1);
        playerQueue.add(player2);


        BattleShipGame battleShipGame = new BattleShipGame(board, board1, player1, player2);
        battleShipGame.start();
    }



}
