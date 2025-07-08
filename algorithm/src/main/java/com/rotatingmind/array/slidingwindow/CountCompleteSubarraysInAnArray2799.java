package com.rotatingmind.array.slidingwindow;

import java.util.*;

/**
 * 2799. Count Complete Subarrays in an Array
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an array nums consisting of positive integers.
 *
 * We call a subarray of an array complete if the following condition is satisfied:
 *
 * The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
 * Return the number of complete subarrays.
 *
 * A subarray is a contiguous non-empty part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,1,2,2]
 * Output: 4
 * Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
 * Example 2:
 *
 * Input: nums = [5,5,5,5]
 * Output: 10
 * Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.
 */
public class CountCompleteSubarraysInAnArray2799 {


    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        int n = nums.length;
        int i = 0;
        int totalDistinctElements = numOfDistinctEle(nums, 0, n);

        while (i < n) {
            for (int j = n; j >= 0; j--) {
                if (totalDistinctElements == numOfDistinctEle(nums, i, j)) {
                    count++;
                } else {
                    break;
                }
            }
            i++;
        }
        return count;
    }



    //Input: nums = [1,3,1,2,2]
    public int countCompleteSubarraysV1(int[] nums) {
        int count = 0;
        int n = nums.length;
        int i = 0;
        int totalDistinctElements = numOfDistinctEle(nums, 0, n);

        while (i < n) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (totalDistinctElements == seen.size()) {
                    count++;
                }
            }
            i++;
        }
        return count;
    }

    //Input: nums = [1,3,1,2,2]
    public int countCompleteSubarraysV2(int[] nums) {
        int result = 0;
        int n = nums.length;
        int i = 0, j = 0;
        int totalDistinctElements = numOfDistinctEle(nums, 0, n);

        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() == totalDistinctElements) {
                result += (n - j);
                var count = map.getOrDefault(nums[i], 0);
                if (count > 1) {
                    map.put(nums[i], (map.get(nums[i]) - 1));
                } else if (count == 1) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return result;
    }

    public int numOfDistinctEle(int[] nums, int start, int end) {
        int count = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i = start; i < end; i++) {
            if(seen.add(nums[i])) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CountCompleteSubarraysInAnArray2799 obj = new CountCompleteSubarraysInAnArray2799();
        int count = obj.countCompleteSubarraysV2(new int[]{1,3,1,2,2});
        //int count1 = obj.countCompleteSubarraysV2(new int[]{5,5,5,5});
        System.out.println("Result " + count);
    }
}
