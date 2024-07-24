package com.rotatingmind.array.hashmap;

/**
 * we have matrix which contains 1 OR 0, what we have to do, we have to transform such that if mat[i][j]  = 1
 *  -> all the cells of ith row should be 1
 *  -> all the cells of jth column should be =1
 *
 *  Example
 *  we'll declare on temp matrix and traverse real matrix and transform on the basis of 0/1
 */
public class BooleanMatrix {


    /**
     *  SC = o(m * n)
     *  TC =  how much time spend on 1 cell == n cell, m cell
     *  o ( m * n (m + n)) ~ o(n^3)
     *
     *  can we do some pre processing
     *  let we are on 6th row , row # is common approx all cells
     *  if we have store row # and column # then we can directly transform that row OR column
     */
    public static int[][] transformMatrixV1(int[][] m) {
        int rowLen = m.length;
        int clLen = m[0].length;

        int[][] tmp = new int[rowLen][clLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < clLen; j++) {

                if (m[i][j] == 1) {
                    transform(tmp, i, j);
                }

            }
        }
        return tmp;
    }


    /**
     * SC = o(m + n)
     * TC = o (m * n)
     * @param m
     */
    public static void  transformMatrixV2(int[][] m) {
        int rowLen = m.length;
        int clLen = m[0].length;

        int[] rowArr = new int[rowLen];
        int[] clmArr = new int[clLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < clLen; j++) {
                if (m[i][j] == 1) {
                    rowArr[i] = 1;
                    clmArr[j] = 1;
                }
            }
        }


        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < clLen; j++) {

                if (rowArr[i] == 1) {
                    m[i][j] = 1;
                }
                if (clmArr[j] == 1) {
                    m[i][j] = 1;
                }
            }
        }
    }


    public static void transform(int[][] tmp, int i, int j) {
        int rowLen = tmp.length;
        int clLen = tmp[0].length;

        for (int k = 0; k < clLen; k++) {
            tmp[i][k] = 1;
        }

        for (int k = 0; k < rowLen; k++) {
            tmp[k][j] = 1;
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
