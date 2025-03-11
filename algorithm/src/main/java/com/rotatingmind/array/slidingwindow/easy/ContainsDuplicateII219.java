package com.rotatingmind.array.slidingwindow.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 */
public class ContainsDuplicateII219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is already in the window
            if (window.contains(nums[i])) {
                return true;
            }

            // Add the current element to the window
            window.add(nums[i]);

            // Maintain window size by removing the oldest element
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;


    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the window & if its already there return true
            if (!window.add(nums[i])) return true;

            // Maintain window size by removing the oldest element when the window exceeds size k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        ContainsDuplicateII219 obj = new ContainsDuplicateII219();
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}
