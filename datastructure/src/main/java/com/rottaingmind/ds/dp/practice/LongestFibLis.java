package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestFibLis {

    public static int lenLongestFibSubseq(int[] arr) {

        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[][] dp = new int[n][n];
        int maxLen = 0;

        // Store each number's index in the map
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Check all pairs (arr[j], arr[i]) where j < i
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = indexMap.getOrDefault(arr[i] - arr[j], -1);

                // Ensure arr[k] exists, k < j to maintain order
                if (k >= 0 && k < j) {
                    dp[j][i] = dp[k][j] + 1;
                    maxLen = Math.max(maxLen, dp[j][i]);
                } else {
                    dp[j][i] = 2; // Default length if not part of a sequence
                }
            }
        }

        return maxLen > 2 ? maxLen : 0;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int len = lenLongestFibSubseq(arr);
        System.out.println("Longest Fib Subseq: " + len);
    }


}
