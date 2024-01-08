package com.rotatingmind.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice {


    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        buySell(arr);
    }

    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]

    public static void buySell(int[] nums) {
        int len = nums.length;
        int maxProfit = Integer.MIN_VALUE;
        int minProfit = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            minProfit = Math.min(minProfit, nums[i]);
            maxProfit = Math.max(maxProfit, nums[i] - minProfit);
        }

        System.out.println(maxProfit);
    }

}
