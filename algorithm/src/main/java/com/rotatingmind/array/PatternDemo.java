package com.rotatingmind.array;

import java.util.stream.IntStream;

public class PatternDemo {

    public static void main(String[] args) {
        /*for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.println("first");
            }
            if (i == 1) {
                System.out.println("second");
            }
            if (i == 2) {
                System.out.println("third");
            }
        }*/

        //IntStream.range(0, 5).forEach(System.out::println);





        /*System.out.println("WE NEED TO");
        System.out.println();
        System.out.println("LEARN JAVA");
        System.out.println();
        System.out.println("AS QUICKLY AS POSSIBLE");
        O X X
        O X O
       X O X
        */
        System.out.println("O X X");
        System.out.println("O X O");
        System.out.println("X O X");

    }

    /*public static void main(String[] args) {
        int row = 8;
        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= row; j++) {
                if (i == 1 || (i == row - 1 & j != 1)
                        || ((j == 1 && i == row - 2) || (j == 1 && i == row - 3))
                        || ((j == 2 && i == row - 2) || (j == 2 && i == row - 3))
                        || j == row || j == row - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }*/
}
