package com.rotatingmind.recursion.leed1863;

public class SumOfAllSubsetXORTotals1863 {

    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

    private int solve(int[] nums, int i, int xor) {
        if (i == nums.length) return xor;

        int included = solve(nums, i + 1, nums[i] ^ xor);

        int excluded = solve(nums, i + 1, xor);

        return included + excluded;
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals1863 solution = new SumOfAllSubsetXORTotals1863();

        int[] nums = {1, 3};
        int result = solution.subsetXORSum(nums);

        System.out.println("Sum of all subset XOR totals: " + result);
        // Expected output: 6
    }
}
