package com.rottaingmind.ds.dp.practice;

public class LongestSubSequenceSumNoAdajacent {

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int m = queries.length;
        int n = nums.length;
        int ans = 0;



        for(int i = 0; i < m; i++) {
            int pos = queries[i][0];
            int x = queries[i][1];
            if (pos < n && pos >= 0) {
                nums[pos] = x;
                Integer[] dp = new Integer [n];
                ans += maximumSumSubsequence(nums, 0, dp);
            }
        }

        return ans;
    }

    public int maximumSumSubsequence(int[] nums, int i, Integer[] dp) {

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int include = nums[i] + maximumSumSubsequence(nums, i + 2, dp);
        int exclude = maximumSumSubsequence(nums, i + 1, dp);

        dp[i] = Math.max(include, exclude);
        return dp[i];
    }

    //bottom-up

    /**
     *
     */

    public static void main(String[] args) {
        LongestSubSequenceSumNoAdajacent obj = new LongestSubSequenceSumNoAdajacent();

        int[] nums = {3,5,9};
        int[][] queries = {{1,-2}, {0,-3}};
        int i = obj.maximumSumSubsequence(nums, queries);
        System.out.println("Result " + i);
    }
}
