package com.rottaingmind.ds.stack.applications;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 *
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 *
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 2 * 105
 * -109 <= nums[i] <= 109
 */
public class Pattern132 {

    //[3, 5, 0, 3, 4]
    //num1 < num3 < num2
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> numStack = new ArrayDeque<>();
        int num3 = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if (nums[i] < num3) {
                return true;
            }

            while (!numStack.isEmpty() && numStack.peek() < nums[i]) {
                num3 = numStack.pop();
            }

            numStack.push(nums[i]);
        }
        return false;
    }




    public static void main(String[] args) {

    }
}
