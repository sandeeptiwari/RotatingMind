package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

public class LongestBitonicCh9 {

    private static int longestBitonic(int n, int[] a) {

        //find lis max
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }

        }

        //find lis max
        int[] lds = new int[n];
        Arrays.fill(lds, 1);

        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {
                if (a[i] > a[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int lbs = 0;
        for (int i = 0; i < n; i++) {
            lbs = Math.max(lbs, lis[i] + lds[i] - 1);
        }
        return lbs;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
        System.out.println(longestBitonic(nums.length, nums));
    }
}
