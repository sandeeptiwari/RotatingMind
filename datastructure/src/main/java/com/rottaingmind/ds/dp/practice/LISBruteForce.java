package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

public class LISBruteForce {
    public static int lis(int[] arr) {
        return lisHelper(arr, 0, Integer.MIN_VALUE);
    }

    private static int lisHelper(int[] arr, int i, int prev) {
        if (i == arr.length) return 0; // Base case: No elements left

        // Exclude the current element
        int exclude = lisHelper(arr, i + 1, prev);

        // Include the current element if it forms an increasing sequence
        int include = 0;
        if (arr[i] > prev) {
            include = 1 + lisHelper(arr, i + 1, arr[i]);
        }

        // Return the maximum of both choices
        return Math.max(include, exclude);
    }


    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLIS = 1;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLIS = Math.max(maxLIS, dp[i]); // Track max LIS length
            }
        }
        return maxLIS;
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        System.out.println("LIS Length: " + lis(arr)); // Output: 3
    }
}
