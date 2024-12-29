package com.rotatingmind.array.sorting;

import java.util.Arrays;

/**
 * The frequency of an element is the number of times it occurs in an array.
 * <p>
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and
 * increment the element at that index by 1.
 * <p>
 * Return the maximum possible frequency of an element after performing at most k operations.
 * <p>
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 */
public class FrequencyOfTheMostFrequentElement {

    /**
     * 1- Sort the array
     * 2- Applying sliding window
     * 3- initially sliding window would be  at 0th index
     * 4 total sum = 1
     * num[r] * windowLen < total + k (is  total budget)
     *
     * @param args
     */
    public static void main(String[] args) {
    }

    //1 2 4
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        long curr = 0;

        for (int right = 0; right < nums.length; right++) {
            int target = nums[right];
            curr += target;

            while ((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
