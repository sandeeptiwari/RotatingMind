package com.rotatingmind.array.hashmap;

import java.util.*;

/**
 * An element x of an integer array arr of length m is dominant if more than half the elements of arr have a value of x.
 *
 * You are given a 0-indexed integer array nums of length n with one dominant element.
 *
 * You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1], but the split is only valid if:
 *
 * 0 <= i < n - 1
 * nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.
 * Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j, both ends being inclusive. Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.
 *
 * Return the minimum index of a valid split. If no valid split exists, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,2]
 * Output: 2
 * Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2].
 * In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3.
 * In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
 * Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split.
 * It can be shown that index 2 is the minimum index of a valid
 */
public class MinimumIndexOfAValidSplit2780 {


    /**
     * nums = [2,1,3,1,1,1,7,1,2,1] Ans: 4
     * @param nums
     * @return
     *
     *
     */
    public int minimumIndex(List<Integer> nums) {
        int candidate = findCandidate(nums); // Step 1: Find dominant candidate
        int[] prefix = new int[nums.size()]; // Step 2: Build prefix sum array

        prefix[0] = nums.get(0) == candidate ? 1 : 0;
        // Step 3: Build prefix array for candidate frequency
        for (int i = 1; i < nums.size(); i++) {
            prefix[i] = prefix[i - 1] + (nums.get(i) == candidate ? 1 : 0);
        }

        int totalFrequency = prefix[nums.size() - 1];

        for (int i = 0; i < nums.size(); i++) {

            int leftCount = prefix[i];
            int rightCount = totalFrequency - prefix[i];

           if (leftCount * 2 > (i + 1) && rightCount * 2 > (nums.size() - i - 1)) {
               return i;
           }
        }
        return -1;
    }

    public int findCandidate(List<Integer> nums) {
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MinimumIndexOfAValidSplit2780 obj = new MinimumIndexOfAValidSplit2780();

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 2, 2));

        System.out.println("Result " + obj.minimumIndex(nums));

    }
}
