package com.rotatingmind.array.slidingwindow;

public class CountSubarraysWithScoreLessThanK2302 {

    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int i = 0, j = 0;
        int sum = 0;
        long count = 0;

        while(j < n) {
            sum += nums[j];

            while(i <= j && (long)sum * ((j - i + 1)) >= k) {
                sum -= nums[i];
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}
