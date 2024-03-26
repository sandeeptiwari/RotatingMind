package com.rotatingmind.twod_array;

import java.util.Scanner;

/**
 * Given an array arr[] with n elements , you need to find the sum all sub arrays of array arr. Since the sum could be very
 * large print the sum modulo
 * 10, * 9+7.
 * Example 1:
 * Input:
 * 3 1 2 3
 * Output:
 * 20
 * Explanation:
 * All subarrays are [1], [2], [3],[1,2], [2,3], [1,2,3]. Thus total sum is 20.
 * Constraints :
 *
 * 1 ≤ n ≤ 10^5
 * 1 ≤ arri ≤ 10^ 9
 */
public class SumOfAllSubArray {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long ans = 0;
        //int m = 10^9 + 7;
        long m = 1000000007;

        for(int i = 0; i < n; i++) {
            int c = (i+1);
            int d = n-i;
            int ai = a[i];
            long contrib = ((c % m * d % m) % m * ai %m )% m;
            ans = (ans % m + contrib % m) % m;
        }

        System.out.print(ans);
    }
}
