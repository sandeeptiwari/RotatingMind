package com.rotatingmind.array.binarysearch_usage;

import java.util.Arrays;

/**
 * There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
 *
 * The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
 *
 * You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.
 *
 * You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.
 *
 * Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,5,9], k = 2
 * Output: 5
 * Explanation:
 * There are three ways to rob at least 2 houses:
 * - Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
 * - Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
 * - Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
 * Therefore, we return min(5, 9, 9) = 5.
 */
public class HouseRobberIV2560 {

    public int minCapabilityD(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1], Math.max(dp[i-2] + nums[i], dp[i-1]));
        }
        return dp[n-1];
    }

    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int)1e9, n = nums.length;
        while (left < right) {
            int mid = (left + right) / 2, take = 0;
            for (int i = 0; i < n; ++i)
                if (nums[i] <= mid) {
                    take += 1;
                    i++;
                }
            if (take >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left; //left == right

    }


    // Helper function to check if we can rob 'k' houses with max value <= 'mid'

    /**
     * mid = 6 sets the maximum limit for valid house values.
     * Since 8 exceeds 6, we cannot include this house in any valid sequence.
     * Counting 8 would mean we're accepting a house whose value is greater than the allowed threshold (mid).
     * Since this breaks the rules, we don't increment valid and simply move to the next house.
     *
     *
     * 🔍 Why Does mid Act Like a Ceiling?
     * In binary search, we use mid as a threshold (ceiling) that represents the maximum value allowed in any valid group of houses.
     *
     * Think of mid as a safety limit:
     *
     * Any house with a value greater than mid is too risky to include in the selected sequence.
     * Our goal is to find the minimum possible ceiling that allows us to select enough valid houses.
     */
    private boolean canRob(int[] nums, int k, int mid) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= mid) { // num[i] is crossing allowed threshold
                count++;  // Found a valid house
                i += 2;   // Skip the next house to avoid adjacency
            } else {
                i++;  // Continue to the next house
            }

            if (count >= k) return true;  // Found enough valid houses
        }

        return false;
    }

    public int minCapabilityV1(int[] nums, int k) {

        int low = Arrays.stream(nums).min().orElse(0);
        int high = Arrays.stream(nums).max().orElse(0);

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (!canRob(nums, k, mid)) {
                low = mid + 1;
            } else {
                if (!canRob(nums, k, mid -1)) {
                    return mid;
                }
                high = mid - 1;
            }
        }

        return low;
    }


    public int minCapabilityV2(int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][k+1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        return rob(nums, 0, k, dp);
    }

    private int rob(int[] nums, int index, int k, int[][] dp) {
        if (index == nums.length) return Integer.MAX_VALUE;
        if (k == 0) {
            return 0; // k house covered
        }

        if (dp[index][k] != -1) return dp[index][k];

        int take = Math.max(nums[index],  rob(nums, index + 2, k - 1, dp));
        int skip = rob(nums, index + 1, k, dp);

        dp[index][k] = Math.min(take, skip);

        return dp[index][k];
    }

    public static void main(String[] args) {
        HouseRobberIV2560 obj = new HouseRobberIV2560();
        int[] nums = {2, 3, 5, 9, 8};
        int k = 2;
        System.out.println("Minimum Maximum Value: " + obj.minCapabilityV1(nums, k));  // Output: 5
    }

}
