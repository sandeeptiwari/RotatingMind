package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * we have matrix which contains 1 OR 0, what we have to do, we have to transform such that if mat[i][j]  = 1
 *  -> all the cells of ith row should be 1
 *  -> all the cells of jth column should be =1
 *  -> all diagonals passing through that cells should be 1
 *
 *  Example
 *  we'll declare on temp matrix and traverse real matrix and transform on the basis of 0/1
 *  Total no of mejor diagonals in n * n matrix =  Here starting cell of each matrix either in 1st row or in 1st column
 *  so Total no of major diagonals = N + N - 1 ( where -1 is because 1st cell of row is common in row and column)
 *
 *  Any major diagonal can be... (i -1, j-1) (i, j) -> (i +1, j + 1) ... increased by 1 and diff of x and y coordinates of major diagonal would be -1
 *     i -j = -1 e.g. i, j = (3, 4) = 3- 4 = -1
 *     next 4, 5 = 4- 5 = -1 so  on so forth
 *
 *     similarly it would be constant for all mjor diagonal i -j = constant
 *
 *  For minor diagonal i + j = constant same as major diagonals
 */
public class BooleanMatrix2 {

    /**
     * SC = o(m + n)
     * TC = o (m * n)
     * Step 1: prepare rowArr and colimn array along that store i -j and i+j
     * @param m
     */
    public static void transformMatrixV2(int[][] m) {
        int rowLen = m.length;
        int clLen = m[0].length;

        int[] rowArr = new int[rowLen];
        int[] clmArr = new int[clLen];

        Map<Integer, Integer> majorDiagonal = new HashMap<>();
        Map<Integer, Integer> minorDiagonal = new HashMap<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < clLen; j++) {
                if (m[i][j] == 1) {
                    rowArr[i] = 1;
                    clmArr[j] = 1;
                    majorDiagonal.put((i - j), 1);
                    minorDiagonal.put((i + j), 1);
                }
            }
        }


        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < clLen; j++) {

                if (rowArr[i] == 1 || clmArr[j] == 1 || majorDiagonal.containsKey(i - j) || minorDiagonal.containsKey(i + j)) {
                    m[i][j] = 1;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[][] m = {
                    {0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0}
                };
        /*int[][] res = transformMatrixV1(m);

        int rowLen = res.length;
        int clLen = res[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < clLen; j++) {
                System.out.print(res[i][j] + " ,");
            }
            System.out.println("");
        }*/

        transformMatrixV2(m);

        int rowLen1 = m.length;
        int clLen1 = m[0].length;

        for (int i = 0; i < rowLen1; i++) {
            for (int j = 0; j < clLen1; j++) {
                System.out.print(m[i][j] + " ,");
            }
            System.out.println("");
        }
    }

}
