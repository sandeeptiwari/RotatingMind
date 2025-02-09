package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

public class HouseRobber {

    //version1
   /* public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rob(n - 1, nums, dp);
    }

    public int rob(int n, int[] nums, int[] dp) {
        if (n < 0) return 0;

        if (n == 0) return nums[0];

        if (dp[n] != -1) {
            return dp[n];
        }

        // exclude
        int exclude = rob(n-1, nums, dp);

        //include
        int include = nums[n] + rob(n-2, nums, dp);

        dp[n] = Math.max(exclude, include);

        return dp[n];
    }*/

    // version -2

    /**
     * Explanation of Key Variables:
     * prev1: The maximum value we can rob from houses up to the previous index.
     * prev2: The maximum value we could rob up to the house before the last one (for skipping one house).
     * We will calculate whether to include the current house or exclude it, and then move to the next house (index - 1).
     *
     *
     * Key Idea:
     * prev1 keeps track of the maximum amount that could be robbed up to the previous house (excluding the current one).
     * prev2 keeps track of the maximum amount that could be robbed up to the house before the previous one.
     *
     * How It Works:
     * When you reach a new house, you have two choices:
     *
     * Exclude the current house. In this case, the maximum amount will be the same as prev1, because you don't rob the current house.
     * Include the current house. In this case, the maximum amount will be the value of the current house (nums[index]) plus the maximum amount robbed two houses ago (prev2). This ensures you are not robbing adjacent houses because you're skipping one house in between.
     * Step-by-Step Example: nums = [2, 7, 9, 3, 1]
     *
     * Initial Call:
     * robHelper(4, nums, 0, 0)
     *
     * prev1 = 0 (Maximum value up to the previous house — none yet)
     * prev2 = 0 (Maximum value two houses before — none yet)
     * Step 1: robHelper(4, nums, 0, 0)
     * We are considering house at index 4 (which is 1).
     *
     * Exclude house at index 4: prev1 = 0
     * Include house at index 4: nums[4] + prev2 = 1 + 0 = 1
     * So, the maximum between including or excluding house at index 4 is 1.
     *
     * We now call robHelper(3, nums, 1, 0) to move on to the next house with the updated values.
     *
     * Step 2: robHelper(3, nums, 1, 0)
     * We are considering house at index 3 (which is 3).
     *
     * Exclude house at index 3: prev1 = 1
     * Include house at index 3: nums[3] + prev2 = 3 + 0 = 3
     * So, the maximum between including or excluding house at index 3 is 3.
     *
     * We now call robHelper(2, nums, 3, 1).
     *
     *
     * robHelper(4, [2, 7, 9, 3, 1], 0, 0)
     *     |
     *     robHelper(3, [2, 7, 9, 3, 1], 1, 0)   // Max rob amount = 1
     *     |
     *     robHelper(2, [2, 7, 9, 3, 1], 3, 1)   // Max rob amount = 3
     *     |
     *     robHelper(1, [2, 7, 9, 3, 1], 10, 3)  // Max rob amount = 10
     *     |
     *     robHelper(0, [2, 7, 9, 3, 1], 10, 10) // Max rob amount = 10
     *     |
     *     robHelper(-1, [2, 7, 9, 3, 1], 12, 10) // Base case
     */
    public int rob(int[] nums) {
        int n = nums.length;
        return rob(n - 1, nums, 0, 0);
    }

    public int rob(int n, int[] nums, int prev1, int prev2) {
        if (n < 0) return prev1;
        // exclude
        int exclude = prev1;

        // Include the current house
        int include = nums[n] + prev2;

        int neewPrev = Math.max(exclude, include);

        return rob(n - 1, nums, neewPrev, prev1);
    }
}
