package com.rotatingmind.recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.
 * <p>
 * Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass
 * immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.
 * (A glass at the bottom row has its excess champagne fall on the floor.)
 * <p>
 * For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are
 * half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured,
 * the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.
 * <p>
 * Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)
 * <p>
 * Example 1:
 * <p>
 * Input: poured = 1, query_row = 1, query_glass = 1
 * Output: 0.00000
 * Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the
 * top glass will remain empty.
 * Example 2:
 * <p>
 * Input: poured = 2, query_row = 1, query_glass = 1
 * Output: 0.50000
 * Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0)
 * and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
 * Example 3:
 * <p>
 * Input: poured = 100000009, query_row = 33, query_glass = 17
 * Output: 1.00000
 * <p>
 * Constraints:
 * <p>
 * 0 <= poured <= 109
 */
public class ChampagneProblem {

    public static double champagneTower(int poured, int query_row, int query_glass) {

        if (poured == 0) return 0;

        List<Double> l = new ArrayList<>();
        l.add(Double.valueOf(poured));

        while (query_row-- > 0) {
            List<Double> temp = new ArrayList<>();
            temp.add(Math.max((l.get(0) - 1) / 2, 0));
            for (int i = 1; i < l.size(); i++) {
                temp.add(Math.max((l.get(i - 1) - 1) / 2, 0) + Math.max((l.get(i) - 1) / 2, 0));
            }
            temp.add(temp.get(0));
            l = new ArrayList<>(temp);
        }

        return Math.min(1, l.get(query_glass));
    }


    public static int countGlass(double[][] a, double n, double t, int i, int j, int cnt) {
        if (t == 0) {
            return 1;
        }


        for (int k = 0; k < i; k++) {
            a[i][k] += countGlass(a, n, (t - 1) / 2, i + 1, j, cnt);
        }
        /*a[i][j] = t;
        if (a[i][j] >= 1) {
            cnt += countGlass(a, n-1, (t - 1) / 2, i + 1, j, cnt);

            cnt += countGlass(a, n-1, (t - 1) / 2, i + 1, j + 1, cnt);
        }*/

        return cnt;
    }

    public static int fullGlassesCount(int n, int t) {
        double[][] pyramid = new double[n][n];
        pyramid[0][0] = t;
        pourChampagne(pyramid, 0, 0, t);

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (pyramid[i][j] >= 1.0) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     *
     Certainly! Let's break down the problem and the solution step by step.

     Problem Description:

     We have a champagne tower in the shape of a pyramid.
     The height of the pyramid is represented by n.
     Champagne is poured into the top glass of the pyramid, and it flows downwards, filling the glasses below.
     Each second, champagne is poured into the top glass. If the glass overflows, the overflow is evenly distributed between the two glasses below it. If a glass overflows at the bottom level, the champagne spills out.
     We need to find the number of glasses that are completely full after pouring champagne for t seconds.
     Understanding the Approach:

     To solve this problem, we can simulate the pouring of champagne using a recursive approach.
     We'll represent the pyramid as a 2D array.
     We'll pour champagne into the top glass (pyramid[0][0]), and recursively distribute overflow to the glasses below.
     We'll continue pouring champagne until t seconds have passed or the entire pyramid is filled.
     Step-by-Step Solution:

     Initialize a 2D array pyramid to represent the champagne tower.
     Start pouring champagne into the top glass (pyramid[0][0]).
     Recursively pour champagne into the glasses below (pyramid[i][j]) until we reach the bottom of the pyramid or t seconds have passed.
     If the current glass overflows, distribute the overflow equally between the two glasses below (pyramid[i+1][j] and pyramid[i+1][j+1]).
     Keep track of the number of glasses that are completely full (i.e., have a champagne level of 1.0).
     Repeat steps 3-5 until all glasses are filled or t seconds have passed.
     Return the count of completely full glasses.
     */
    public static void pourChampagne(double[][] pyramid, int i, int j, int t) {
        if (i < pyramid.length && j <= i && t > 0) {
            double overflow = Math.max(0, pyramid[i][j] - 1.0);
            pyramid[i][j] = Math.min(1.0, pyramid[i][j]);

            if (overflow > 0) {
                if (i + 1 < pyramid.length) {
                    pyramid[i + 1][j] += overflow / 2.0;
                    pyramid[i + 1][j + 1] += overflow / 2.0;
                }
            }

            pourChampagne(pyramid, i + 1, j, t - 1);
            pourChampagne(pyramid, i + 1, j + 1, t - 1);
        }
    }

    public static void main(String[] args) {
        double[][] pyramid = new double[3][3];
        double amt = fullGlassesCount(3, 5);
        System.out.println("Amount :: " + amt);

    }



    /*public static void main(String[] args) {
        int poured = 2;
        int queryRow = 1;
        int query_glass = 1;
        double amt = champagneTower(poured, queryRow, query_glass);
        System.out.println("Amount :: " + amt);

    }*/

}
