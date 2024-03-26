package com.rotatingmind.twod_array;

import java.util.Scanner;

public class LowerAndUpperTriangle {

    //lower triangle  i, j : i <= j
    // upper triangle part i, j : i >= j
    //for(j = i; j< n; j++


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int a[][] = new int[n1][m1];


        for(int i = 0; i < n1; i++) {

            for(int j = 0; j < m1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int sumOfUpperPart = 0;
        int sumOfLowerPart = 0;

        for (int i = 0; i < n1; i++) {

            for (int j = 0; j <= i; j++) {
                sumOfLowerPart += a[i][j];
            }
        }

        for (int i = 0; i < n1; i++) {

            for (int j = i; j < m1; j++) {
                sumOfUpperPart += a[i][j];
            }
        }

        System.out.println(sumOfUpperPart);
        System.out.println(sumOfLowerPart);
    }


}
