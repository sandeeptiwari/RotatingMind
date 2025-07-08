package com.rotatingmind.two_pointer;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition1498 {

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        long count = 0;
        int l = 0, r = n - 1;
        Arrays.sort(nums);

        while (l <= r) {
            int sum = nums[l] + nums[r];
            if (sum <= target) {
                int diff = r - l;
                count += (long) Math.pow(2, diff);
                l++;
            } else {
                r--;
            }
        }

        return (int) count;
    }
}
