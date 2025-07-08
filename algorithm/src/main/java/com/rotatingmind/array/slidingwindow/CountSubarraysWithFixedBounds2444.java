package com.rotatingmind.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums and two integers minK and maxK.
 *
 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
 *
 * The minimum value in the subarray is equal to minK.
 * The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * Output: 2
 * Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 * Example 2:
 *
 * Input: nums = [1,1,1,1], minK = 1, maxK = 1
 * Output: 10
 * Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 */
public class CountSubarraysWithFixedBounds2444 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                int min = minInRange(nums, i, j);
                int max = maxInRange(nums, i, j);
                if (min == minK && max == maxK) {
                    count++;
                }

            }
        }
        return count;
    }

    public int minInRange(int[] nums, int start, int end) {
        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    public int maxInRange(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public long countSubarraysV1(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int minVal = nums[i], maxVal = nums[i];

            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[i]);
                maxVal = Math.min(maxVal, nums[i]);
                if (minVal == minK && maxVal == maxK) {
                    count++;
                }

            }
        }
        return count;
    }

    public long countSubarraysV2(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;
        int lastMin = -1;
        int lastMax = -1;
        int lastInvalid = -1;



        for (int i = 0; i < n; i++) {
            if (lastMin == minK) {
                lastMin = i;
            }
            if (lastMax == maxK) {
                lastMax = i;
            }
            if (nums[i] < lastMin || nums[i] > lastMax) {
                lastInvalid = i;
            }

            count += Math.max(Math.min(lastMin, lastMax), lastInvalid - 1);
        }
        return count;
    }


    public static void main(String[] args) {
        CountSubarraysWithFixedBounds2444 obj = new CountSubarraysWithFixedBounds2444();
        //System.out.println(obj.countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
        System.out.println(obj.countSubarrays(new int[]{1,1,1,1}, 1, 1));
    }
}
