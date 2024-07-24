package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * Example 2:
 *
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
public class FourSumII {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                for(int k : nums3)
                    for(int l : nums4)
                        if(i + j + k + l == 0) count++;
        return count;
    }

    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int l : nums4)
            map.put(l, map.getOrDefault(l, 0) + 1); // if number already present the inrement with + 1, otherwise add in map
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                for(int k : nums3)
                    count += map.getOrDefault(-(i + j + k), 0); // we have to find out the -ve of i + j + k
        // & in d we have to find such no that -(i + j + k) + l gives = 0. If it is there get it otherwise get 0
        // and update the count
        return count;
    }

    /**
     * Now as you can see we have optimize it more. And the time complexity of solution has reduce from O(N^3) -> O(N^2)
     * ANALYSIS :-
     *
     * Time Complexity :- BigO(N^2)
     *
     * Space Complexity :- BigO(N^2)
     */
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : nums3)
            for(int l : nums4)
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                count += map.getOrDefault(-(i + j), 0);
        return count;
    }
}
