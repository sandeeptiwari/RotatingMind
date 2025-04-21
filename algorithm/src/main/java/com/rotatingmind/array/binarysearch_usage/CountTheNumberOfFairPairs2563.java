package com.rotatingmind.array.binarysearch_usage;

import java.util.Arrays;

/**
 * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
 *
 * A pair (i, j) is fair if:
 *
 * 0 <= i < j < n, and
 * lower <= nums[i] + nums[j] <= upper
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * Output: 6
 * Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
 * Example 2:
 *
 * Input: nums = [1,7,9,2,5], lower = 11, upper = 11
 * Output: 1
 * Explanation: There is a single fair pair: (2,3).
 *
 */
public class CountTheNumberOfFairPairs2563 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        long result = 0;
        int n = nums.length;
        Arrays.sort(nums);

        //0,1,4,4,5, 7
        for (int i = 0; i < n; i++) {
            int idx = lowerBound(nums, i + 1, lower - nums[i]);
            long x = idx - 1 - i;

            long idxUpper = upperBound(nums, i + 1, upper - nums[i]);

            long y = idxUpper - i - 1;

            result += (y - x);
        }
      return result;
    }

    public static int lowerBound(int[] nums, int start, int target) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // Gives the first element NOT LESS than (lower - nums[i]) // log(n)
    }

    //1, 3, 3, 5, 7, 9
    public static int upperBound(int[] nums, int start, int target) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // Gives the first element GREATER than (lower - nums[i]) // log(n)
    }


    public static void main(String[] args) {
        int[] nums = {0,1,7,4,4,5};

        CountTheNumberOfFairPairs2563 obj = new CountTheNumberOfFairPairs2563();
        System.out.println(obj.countFairPairs(nums, 3, 6));
    }
}
