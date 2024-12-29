package com.rotatingmind.array.slidingwindow;

import java.util.Arrays;

/**
 * Given an array of N integers where each value represents the number of chocolates in a packet. Each packet can have
 * a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:
 * <p>
 * Each student gets one packet.
 * The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum
 * chocolates given to the students is minimum.
 * <p>
 * Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3
 * Output: Minimum Difference is 2
 */
public class ChocolateDistribution {

    /**
     * 1 - sort the array -> {2,3, 4, 7, 9, 12, 56}
     * 2 -
     */

    public static int chocolateDistribution(int[] a, int m) {
        int n = a.length;

        // Check base cases
        if (n == 0 || m == 0) {
            return 0;
        }

        // Check if there are enough packets for the given number of students
        if (n - 1 < m) {
            // Invalid input
            return -1;
        }

        // Sort the array to simplify calculations
        Arrays.sort(a);

        int window = m;

        int diff = a[window - 1] - a[0];

        for (int i = window; i < n; i++) {
            diff = Math.min((a[i] - a[(i - (window-1))]), diff);
        }

        return diff;
    }

    public static void main(String[] args) {
        //int[] a = {7, 3, 2, 4, 9, 12, 56};
        //int m = 3;

       // int[] a = {3, 4, 1, 9, 56, 7, 9, 12};
        //int m = 5;

        int[] a = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;

        int result = chocolateDistribution(a, m);

        System.out.println("Result " + result);
    }
}
