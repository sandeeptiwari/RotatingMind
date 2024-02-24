package com.rotatingmind.twod_array;

public class AddingTwoMatrix {

    public static int[][] sum(int[][] m1, int[][] m2) {

        int l = m1.length;
        int[][] c = new int[l][m1[0].length];

        for (int i = 0; i < l; i++) {

            for (int j = 0; j < m1[0].length; j++) {

                c[i][j] = m1[i][j] + m2[i][j];

            }
        }

        return c;
    }

    public static void main(String[] args) {
        int a[][]={{1,3,4},{2,4,3},{3,4,5}};
        int b[][]={{1,3,4},{2,4,3},{1,2,4}};
        int c[][] = sum(a, b);

        for (int i = 0; i < c.length; i++) {

            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }

            System.out.println();
        }
    }
}
