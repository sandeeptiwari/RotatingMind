package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 * Example 1:
 *
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class SubarraySumsDivisibleByK {

    public static int getSubArraysSumDivisibleByk(int[] nums, int k) {
        int n = nums.length;

        int count  = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;

            for (int j = i; j < n; j++) {

                sum += nums[j];

                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Steps Detail:
     * In an array a[] = {4,5,0,-2,-3,1}
     * k = 5
     * if sum of till i = 0 mod k = x
     * and sum of ele till j = 1 mod k = again x
     * it means ele between i and j must be divisible by k
     * het j - i = 1 ele at a[1] = 5 % 5 = 0 which is divisible by k
     * Example : 2:
     * if i = 0 (exclusion) and j = 2
     * j - i = 2 = will consider 5 and 0 5 + 0  = 5 % 5 = 0
     *
     * Example 3:
     *  i = 0, j = 4
     *  4 = rem till 4 = 4
     *  4,5,0,-2,-3 = rem till j = 4 = 4
     *
     *  it means that 5,0,-2,-3 = 5 % 5 = 0
     *
     */
    public static int getSubArraysSumDivisibleBykV1(int[] nums, int k) {
        int n = nums.length;

        int ps  = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int rem = 0;

        for (int i = 0; i < n; i++) {
            ps += nums[i];
            rem = ps % k;

            if (rem < 0) {
                rem += k;  // to handle the mod when prefix sum is negative.
            }

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {4,5,0,-2,-3,1};
        //4, 4, 4, 2, 4, 0
        int k = 5;
        System.out.println(getSubArraysSumDivisibleBykV1(a, k));
    }
}
