package com.rotatingmind.array.slidingwindow.medium;

import java.util.stream.IntStream;

/**
 * Goal:
 * Given an integer array nums, find the length of the longest nice subarray.
 *
 * A nice subarray is defined as follows:
 * ✅ All elements in the subarray must be bitwise AND compatible — meaning the result of ANDing any two elements in the subarray must be 0.
 *
 * 🔎 Key Observations
 * 1. Bitwise AND Compatibility Condition
 *
 *   For two numbers a and b to be AND-compatible:
 *    a&b=0
 *  This means they have no common set bits.
 *
 * Subarray Expansion Strategy
 *
 *  Use a two-pointer sliding window approach to expand and shrink the window based on compatibility.
 *
 *  💡 Approach: Sliding Window with Bitmask
 * Initialize Variables:
 *
 * left = 0 → Left boundary of the window
 * bitmask = 0 → Tracks the bitwise OR of numbers in the current window
 * maxLength = 0 → Tracks the longest valid window found
 * Iterate Through nums with a Right Pointer:
 *
 * For each nums[right], check if adding it to the bitmask maintains the AND-compatible condition:
 * Condition: (bitmask & nums[right]) == 0
 * If ✅ → Add nums[right] to the window.
 * If ❌ → Shrink the window by moving the left pointer forward until the condition is satisfied.
 * Update Results:
 *
 * After each iteration, update maxLength as:
 *
 * maxLength=max(maxLength,right−left+1)
 *
 * Example 1:
 *
 * Input: nums = [1,3,8,48,10]
 * Output: 3
 * Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
 * - 3 AND 8 = 0.
 * - 3 AND 48 = 0.
 * - 8 AND 48 = 0.
 * It can be proven that no longer nice subarray can be obtained, so we return 3.
 * Example 2:
 *
 * Input: nums = [3,1,5,11,13]
 * Output: 1
 * Explanation: The length of the longest nice subarray is 1. Any subarray of length 1 can be chosen.
 */
public class LongestNiceSubarray2401 {

    //1. brute force - o (n^3)
    public int longestNiceSubarray1(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isNice(nums, i, j)) {
                    ans = Math.max(ans, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return ans;
    }

    // Helper method to check if subarray nums[i..j] is nice
    private boolean isNice(int[] nums, int start, int end) {
        int bitmask = 0;
        for (int k = start; k <= end; k++) {
            if ((bitmask & nums[k]) != 0) {
                return false; // Conflict found
            }
            bitmask |= nums[k]; // Add current number's bits to bitmask
        }
        return true;
    }


    //2. brute force - o (n^2)
    public int longestNiceSubarray2(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int bitmask = 0;

            for (int j = i; j < n; j++) {
                if ((bitmask & nums[j]) != 0) {
                    break;
                }
                ans = Math.max(ans, j - i + 1);
                bitmask |= nums[j];
            }
        }

        return ans;
    }

    //3. Linear - o (n)
    public int longestNiceSubarray3(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int bitmask = 0;

        for (int i = 0; i < n; i++) {


        }

        return ans;
    }


    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        int bitmask = 0; //tracks the bitwise OR of numbers in the current window

        for (int right = 0; right < n; right++) {
            // While the AND condition fails, shrink the window
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left];  // Remove nums[left] from bitmask
                left++;                // Move left pointer forward
            }

            // Add current number to the bitmask
            bitmask |= nums[right];

            // Track the maximum window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
