package com.rotatingmind.twod_array;

import java.util.Scanner;

/**
 * Sample Input 1
 * 3 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Sample Output 1
 * 25
 *
 * Explanation
 * Diagonals sum:
 * 1
 * +
 * 5
 * +
 * 9
 * +
 * 3
 * +
 * 7
 * =
 * 25
 *  Notice that element
 * m
 * a
 * t
 * [
 * 1
 * ]
 * [
 * 1
 * ]
 * =
 * 5
 *  is counted only once
 */
public class DiagonalSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][m];

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int primaryDiaSum = 0;


        if (n == m) {

            for(int i=0,j=0; i < n;) {

                primaryDiaSum += a[i][j];
                i++;
                j++;
            }

            for(int i = 0,j = m-1; i < n;) {

                if(i != j) {
                    primaryDiaSum += a[i][j];
                }
                i++;
                j--;
            }
            System.out.println(primaryDiaSum);
        }
    }
}
