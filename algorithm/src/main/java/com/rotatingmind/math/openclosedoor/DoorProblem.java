package com.rotatingmind.math.openclosedoor;

/**
 * We have n doors (labels with 1, 2, ... n), initially all are closed
 * Rules: we have n rounds in ith round you toggle state of all doors which all are multiples of i
 * when game is over how many doors at the end of the game remains open
 * observation:
 * 1. if we toggle door odd number of times it will remain open and if we toggle door even number of times
 * it will remain close at the end.
 *
 * 2. Now how would we know that which door toggle for even or odd number of time: its depend on number of divisor of that door count
 * lets say ith door has even number of factors then it would be remain open so we need to claculate factors of each door
 * if door number is perfect square then its odd number of factors and its remain open
 * else closed
 *
 * Now how would be clculate could of perfect square from 1 .. n
 *  ->
 *
 *
 */
public class DoorProblem {

    public static void printNumOfOpenDoors(int totalDoorCount) {
        int n = (int)Math.sqrt(totalDoorCount);

        System.out.println("Open " + n);
        System.out.println("Closed  " + (totalDoorCount - n));

    }

    public static void main(String[] args) {
        printNumOfOpenDoors(5);
    }

}
