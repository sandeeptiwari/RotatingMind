package com.rotatingmind.array;

public class FindLongestMonotonicIncAndDec {

    public int longestMonotonicSubarray(int[] nums) {

        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int ans1 = Integer.MIN_VALUE;
        int lis = 1;
        int lds = 1;

        if (n == 1)
            return 1;

        for(int i = 0; i < n -1; i++) {
            if (nums[i] < nums[i+1]) {
                lis++;
                ans = Math.max(ans, lis);
            } else {
                ans = Math.max(ans, lis);
                lis = 1;
            }

            if (nums[i] > nums[i+1]) {
                lds++;
                ans1 = Math.max(ans1, lds);
            } else {
                ans1 = Math.max(ans1, lds);
                lds = 1;
            }
        }

        return Math.max(ans1, ans);

    }


    public int longestMonotonicSubarrayV1(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int inc = 1, dec = 1, maxLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1; // Reset decreasing counter
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1; // Reset increasing counter
            } else {
                inc = 1;
                dec = 1; // Reset both on equal numbers
            }

            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }

        return maxLen;
    }
}
