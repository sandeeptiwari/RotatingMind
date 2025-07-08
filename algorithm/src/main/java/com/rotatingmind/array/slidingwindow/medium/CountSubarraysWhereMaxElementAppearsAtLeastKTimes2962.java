package com.rotatingmind.array.slidingwindow.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an integer array nums and a positive integer k.
 *
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 *
 * A subarray is a contiguous sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 * Example 2:
 *
 * Input: nums = [1,4,2,1], k = 3
 * Output: 0
 * Explanation: No subarray contains the element 4 at least 3 times.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= 105
 */
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes2962 {

    public long countSubarrays(int[] nums, int k) {
        int i = 0, j = 0;
        int maxCount = 0;
        long result = 0;
        int n = nums.length;

        int targetMax = Integer.MIN_VALUE;

        for(int l = 0; l < n; l++) {
            targetMax = Math.max(targetMax, nums[l]);
        }



        while(j < n) {
            if (nums[j] == targetMax)
                maxCount++;

            while(maxCount >= k) {
                result += (n-j);

                if (nums[i] == targetMax) {
                    maxCount--;
                }

                i++;
            }

            j++;
        }

        return result;
    }
}
