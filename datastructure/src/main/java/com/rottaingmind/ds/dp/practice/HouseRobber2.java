package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

public class HouseRobber2 {

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


    /*public int rob(int[] nums) {
        int n = nums.length;

        // Base case: if no houses or only one house, return the result directly
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Case 1: Rob from house 0 to house n-2 (exclude the last house)
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: Rob from house 1 to house n-1 (exclude the first house)
        int case2 = robLinear(nums, 1, n - 1);

        // Return the maximum of both cases
        return Math.max(case1, case2);
    }

    // Helper method to handle the linear robbery (non-circular)
    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber2 solution = new HouseRobber2();

        int[] nums = {2, 3, 2};
        System.out.println(solution.rob(nums));  // Output: 3
    }*/
}
