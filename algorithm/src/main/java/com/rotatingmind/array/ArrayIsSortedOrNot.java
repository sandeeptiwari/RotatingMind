package com.rotatingmind.array;

import java.util.Arrays;

public class ArrayIsSortedOrNot {

    public boolean isArraySorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isArraySortedJava8(int[] nums) {
        return Arrays.stream(Arrays.stream(nums)
                .sorted()
                .toArray()).allMatch(i -> i == nums[i]);
    }


    public static void main(String[] args) {
        ArrayIsSortedOrNot arrayIsSortedOrNot = new ArrayIsSortedOrNot();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(arrayIsSortedOrNot.isArraySorted(nums));
        System.out.println(arrayIsSortedOrNot.isArraySortedJava8(nums)); //NOt working
    }
}
