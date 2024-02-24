package com.rotatingmind.array;

import java.util.*;

public class Practice {


    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSumV2(arr);
        System.out.println("Result " + i);
    }

    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]
    public static void  productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] preProd = new int[len];
        int[] postProd = new int[len];

        preProd[0] = nums[0];

        //1- [1, 2, 3 ,4 ]
        //2- [1, 2, 3 ,4 ]
        //3- [1, 2, 6, 24 ]
        for (int i = 1; i < len; i++) {
            preProd[i] = preProd[i - 1] * nums[i];
        }

        //1- [1, 2, 12 ,4 ]
        //2- [1, 24, 12 ,4 ]
        //3- [24, 24, 12 ,4 ]
        postProd[0] = nums[len-1];
        for (int i = len - 2; i > 0; i--) {
            postProd[i] = postProd[i + 1] * nums[i];
        }

        nums[0] = postProd[1];
        nums[len-1] = preProd[len-2];

    }


    /**
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */

    public static int maxSum(int[] nums) {
        int len = nums.length;
        int maxExtendingSum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];

                if (maxExtendingSum < sum) {
                    maxExtendingSum = sum;
                }
            }

        }
        return maxExtendingSum;
    }

    public static int maxSumV1(int[] nums) {
        int result = nums[0];
        int maxExtendingSum = Integer.MIN_VALUE;
        int len = nums.length;

        if (nums.length == 1) return nums[0];

        for (int i = 1; i < len; i++) {

            result += nums[i];

            if (maxExtendingSum < result) {
                maxExtendingSum = result;
            }

            if (result < 0) {
                result = 0;
            }
        }
        return maxExtendingSum;
    }


    //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    public static int maxSumV2(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
