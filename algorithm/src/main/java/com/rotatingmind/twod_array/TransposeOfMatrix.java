package com.rotatingmind.twod_array;

import java.util.Scanner;

/**
 * 3 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * <p>
 * Output:
 * 1 4 7
 * 2 5 8
 * 3 6 9
 */
public class TransposeOfMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][m];
        int t[][] = new int[m][n];
        int temp = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                    /*
                        temp = a[i][j];
                        a[i][j] = a[j][i];
                        a[j][i] = temp;
                    */
                t[i][j] = a[j][i];
            }
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

    }
}
