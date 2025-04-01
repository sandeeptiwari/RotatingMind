package com.rotatingmind.array.precompute;

/**
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
 *
 * You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that subarray nums[fromi..toi] is special or not.
 *
 * Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,4,1,2,6], queries = [[0,4]]
 *
 * Output: [false]
 *
 * Explanation:
 *
 * The subarray is [3,4,1,2,6]. 2 and 6 are both even.
 */
public class SpecialArrayII3152 {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        return new boolean[] {true};
    }
}
