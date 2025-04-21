package com.rotatingmind.recursion.leed1863;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the
 * elements in both subsets is equal or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * Observations:
 *
 * If you can split the array into two subsets with equal sum, then:
 *
 * sum(nums) % 2 == 0   ➝ total must be even
 * target = sum(nums) / 2
 *
 * Now your task is to check if there exists a subset of nums whose sum is target.
 *
 * So the problem becomes a classic:
 *
 * Subset Sum Problem (0/1 Knapsack-style)
 */
public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        return canPartition(nums, 0, target);
    }

    /**
     * Time Complexity: O(2^n)
     * 👎 Not good for n > 20 (TLE on large cases)
     */
    private boolean canPartition(int[] nums, int idx, int target) {
        if (target == 0) return true;
        if (idx == nums.length || target < 0) return false;

        // Choose or skip current number
        return canPartition(nums, idx + 1, target - nums[idx]) || canPartition(nums, idx + 1, target);
    }

    /**
     * 🟡 2. Top-Down DP with Memoization
     * Cache the result for each (index, target) to avoid recomputation.
     *
     * 🕒 Time Complexity: O(n * target)
     * ✅ Much better than brute force
     */
    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Map<String, Boolean> memo = new HashMap<>();

        if (sum % 2 != 0) return false;

        int target = sum / 2;



        return canPartition1(nums, 0, target, memo);
    }

    private boolean canPartition1(int[] nums, int idx, int target, Map<String, Boolean> memo) {
        if (target == 0) return true;
        if (idx == nums.length || target < 0) return false;

        String key = idx + "," + target;
        if (memo.containsKey(key)) return memo.get(key);

        // Choose or skip current number
        boolean result =  canPartition(nums, idx + 1, target - nums[idx]) || canPartition(nums, idx + 1, target);

        memo.put(key, result);
        return result;
    }

    public boolean canPartition3(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // Base case

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
