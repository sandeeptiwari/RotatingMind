package com.rotatingmind.array;

import java.util.Arrays;

public class FindTheMaxSumOfSubArray {

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int curr = 0;
            for (int j = i; j < nums.length; j++) {
                curr += nums[j];
                maxSum = Math.max(maxSum, curr);
            }
        }
         return maxSum;
    }


    public static int maxSubArrayV1(int[] nums) {
        int result = nums[0];
        int maxExtendingSum = nums[0];

        if (nums.length == 1) return nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxExtendingSum = Math.max(maxExtendingSum + nums[i], nums[i]);
            result = Math.max(maxExtendingSum, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int rs = maxSubArrayV1(nums);
        System.out.println("Ele :: " + rs);
    }
}
