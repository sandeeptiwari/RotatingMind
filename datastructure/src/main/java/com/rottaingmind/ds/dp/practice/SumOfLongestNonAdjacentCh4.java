package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

/**
 * Arr = [1, 10, 100, 40, 20
 *
 * Issues:
 * Shared dp Array for Two Calls
 *
 * You are using the same dp array for both rob(0, n - 1, nums, dp) and rob(1, n, nums, dp).
 * Since dp stores memoized values, the second call may be affected by values from the first call, leading to incorrect results.
 * Fix: Use separate dp arrays for the two cases.
 * Incorrect dp Array Size Handling
 *
 * If nums.length == 1, your code tries to create dp with n = 1, which will lead to dp[0] = -1 but dp[1] will be out of bounds.
 * Fix: Directly return nums[0] when nums.length == 1.
 * Array Index Handling
 *
 * rob(0, n - 1, nums, dp) should consider houses from index 0 to n-2 (excluding n-1).
 * rob(1, n, nums, dp) should consider houses from index 1 to n-1 (excluding 0).
 * Your second call rob(1, n, nums, dp) goes until n, but it should stop at n-1.
 *
 * https://leetcode.com/problems/house-robber-ii/?orderBy=most_votes
 */
public class SumOfLongestNonAdjacentCh4 {


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(robHelper(0, n - 1, nums, dp1), robHelper(1, n, nums, dp2));

    }

    private int robHelper(int i, int n, int[] nums, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        dp[i] = Math.max(nums[i] + robHelper(i + 2, n, nums, dp), robHelper(i + 1, n, nums, dp));
        return dp[i];
    }

    /**
     *
     * Instead of dp arrays, we can use variables to store the previous two values:
     */
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0; // Variables to track max loot at i-1 and i-2
        for (int i = start; i <= end; i++) {
            int temp = Math.max(prev1, prev2 + nums[i]); // Either rob or skip
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }


    public static void main(String[] args) {
        SumOfLongestNonAdjacentCh4 obj = new  SumOfLongestNonAdjacentCh4();
        System.out.println(obj.rob(new int[] { 1, 2, 3}));
    }
}
