package com.rotatingmind.array;

import java.util.Arrays;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOne3191 {

    public int minOperations(int[] nums) {
        int n = nums.length;

        int count = 0;

        for(int i = 0; i < n - 2; i++) {

            if (nums[i] == 0) {
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];

                count++;
            }
        }
        boolean isAllOne = Arrays.stream(nums).allMatch(num -> num == 1);
        return isAllOne ? count : -1;
    }
}
