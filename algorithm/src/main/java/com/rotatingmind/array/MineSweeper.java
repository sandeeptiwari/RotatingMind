package com.rotatingmind.array;

import java.util.ArrayDeque;
import java.util.Queue;

public class MineSweeper {

    public static void main(String[] args) {
        MineSweeper obj = new MineSweeper();
        /*int[][] a = {
                {0, 0},
                {0, 1},
        };
        int[][] ints = obj.fillTheArray(a, 3, 4);*/

       // int[][] field2 = {{-1, 1, 0, 0},
         //       {1, 1, 0, 0},
           //     {0, 0, 1, 1},
             //   {0, 0, 1, -1}};

        //int[][] ints = obj.click(field2, 4, 4, 0, 1); //should return:
        int[][] field2 =
                {
                 {-1, 1, 0, 0},
                 {1, 1, 0, 0},
                 {0, 0, 1, 1},
                 {0, 0, 1, -1}
                };

        int[][] ints = obj.click(field2, 4, 4, 1, 2); //should return:
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]



        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int[][] fillTheArray(int[][] bombs, int numRows, int numCol) {

        int[][] arr = new int[numRows][numCol];

        for (int bomb[] : bombs) {
            int rowI = bomb[0];
            int colI = bomb[1];
            arr[rowI][colI] = -1;

            for (int i = rowI - 1; i < rowI + 1; i++) {
                for (int j = colI - 1; j < colI + 1; j++) {

                    if (0 <= i && i < numRows && 0 <= j && j < numCol && arr[i][j] != -1) {
                        arr[i][j] += 1;
                    }

                }

            }
        }
        return arr;
    }

    public int[][] click(int[][] fields, int numRows, int numCols, int givenI, int givenJ) {
        Queue<Integer[]> toCheck = new ArrayDeque<>();

        if (fields[givenI][givenJ] == 0) {
            fields[givenI][givenJ] = -2;
            Integer[] loc = {givenI, givenJ};
            toCheck.add(loc);
        } else {
            return fields;
        }

        while (!toCheck.isEmpty()) {
            Integer[] current = toCheck.remove();

            int currentI = current[0];
            int currentJ = current[1];

            for (int i = currentI - 1; i <= currentI + 1; i++) {
                for (int j = currentJ - 1; j <= currentJ + 1; j++) {
                    if (0 <= i && i < numRows && 0 <= j
                            && j < numCols
                            && fields[i][j] == 0) {
                        fields[i][j] = -2;
                        Integer[] loc = {i, j};
                        toCheck.add(loc);
                    }
                }
            }

        }
        return fields;
    }
}
