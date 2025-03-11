package com.rotatingmind.array.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSumSubarrayOfSizeK2461 {

    //nums = [1,5,4,2,9,9,9], k = 3
    //nums = [4,4,4], k = 3
    //nums = [1,2,2,3, 4, 5, 5], k = 3
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0, currentSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        int left = 0;  // Left pointer for sliding window

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // Shrink window if size exceeds 'k'
            if (right - left + 1 > k) {
                int outgoing = nums[left];
                currentSum -= outgoing;
                if (freqMap.get(outgoing) == 1) {
                    freqMap.remove(outgoing);
                } else {
                    freqMap.put(outgoing, freqMap.get(outgoing) - 1);
                }
                left++;
            }

            // If window size is 'k' and all elements are distinct
            if (right - left + 1 == k && freqMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;

    }


    public static void main(String[] args) {
        MaximumSumSubarrayOfSizeK2461 obj = new MaximumSumSubarrayOfSizeK2461();
        long l = obj.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3);
        long l1 = obj.maximumSubarraySum(new int[]{4, 4, 4}, 3);
        long l2 = obj.maximumSubarraySum(new int[]{1, 1, 1, 7, 8, 9}, 3); // 24

        System.out.println("Result :: " + l);
        System.out.println("Result :: " + l1);
        System.out.println("Result :: " + l2);
    }

}
