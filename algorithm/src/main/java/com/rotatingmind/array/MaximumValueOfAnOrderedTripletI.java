package com.rotatingmind.array;

/**
 * You are given a 0-indexed integer array nums.
 *
 * Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
 *
 * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
 *
 * Example 1:
 *
 * Input: nums = [12,6,1,2,7]
 * Output: 77
 * Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
 * It can be shown that there are no ordered triplets of indices with a value greater than 77.
 *
 * Example 2:
 * Input: nums = [1,10,3,4,19]
 * Output: 133
 * Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
 * It can be shown that there are no ordered triplets of indices with a value greater than 133.
 *
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 0
 * Explanation: The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.
 *
 * Constraints:
 *
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class MaximumValueOfAnOrderedTripletI {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        long maxVal = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long diff = Math.max((long)nums[i] - nums[j], 0);
                    long value = diff * nums[k];
                    maxVal = Math.max(maxVal, value);
                }
            }
        }

        return maxVal;
    }

    public long maximumTripletValueV1(int[] nums) {
        int n = nums.length;
        long maxValue = 0;
        int maxNum = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, (maxDiff) * maxNum);
            maxNum = Math.max(maxNum, nums[i]);
            maxDiff = Math.max(maxDiff, maxNum - nums[i]);
        }
        return maxValue;
    }

    public long maximumTripletValueV2(int[] nums) {

        int n = nums.length;
        if (n < 3) return 0;
        int left = nums[0];
        int maxVal = 0;

        for (int i = 1; i < n; i++) {

            if (left < nums[i]) {
                left = nums[i];
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                int val = (left - nums[i]) * nums[j];
                maxVal = Math.max(maxVal, val);
            }

        }

        return maxVal;
    }

    public long maximumTripletValueV3(int[] nums) {
        int n = nums.length;

        long[] maxLeft = new long[n];
        long[] maxRight = new long[n];

        maxLeft[0] = 0;
        maxRight[n - 1] = 0;

        long ans = Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        for (int i = n-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {

            ans = Math.max(ans, (maxLeft[i] - nums[i]) * maxRight[i]);
        }

        return ans;
    }


    public static void main(String[] args) {
        MaximumValueOfAnOrderedTripletI obj = new MaximumValueOfAnOrderedTripletI();
        int[] a = {12,6,1,2,7};
        int[] a1 = {1,10,3,4,19};

        long res = obj.maximumTripletValueV2(a1);
        System.out.println("Result :: " + res);
    }
}
