package com.rotatingmind.array;

public class FindTheMaxSumOfSubArrayKadansAlgo {

    public static int sum(int[] a) {
        int n = a.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = getSum(a, i, j);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int getSum(int[] a, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += a[k];
        }
        return sum;
    }




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

    public static int maxSubArrayV2(int[] nums) {
        int maxSum = 0;
        int currSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if (maxSum < currSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-5, 4, 6, -3, 4, -1};
        int rs = maxSubArrayV2(nums);
        System.out.println("Ele :: " + rs);
    }
}
