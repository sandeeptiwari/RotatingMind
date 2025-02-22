package com.rotatingmind.array;

public class SpecialArray {

    public static boolean isArraySpecial(int[] nums) {
        int n = nums.length;

        if (n == 1) return true;

        for(int i = 0; i < n - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5};
        System.out.println(isArraySpecial(nums));
    }
}
