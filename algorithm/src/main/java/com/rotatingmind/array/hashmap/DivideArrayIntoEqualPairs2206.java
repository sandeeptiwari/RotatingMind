package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums consisting of 2 * n integers.
 *
 * You need to divide nums into n pairs such that:
 *
 * Each element belongs to exactly one pair.
 * The elements present in a pair are equal.
 * Return true if nums can be divided into n pairs, otherwise return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3,2,2,2]
 * Output: true
 * Explanation:
 * There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
 * If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.
 *
 *
 * Constraints:
 *
 * nums.length == 2 * n
 * 1 <= n <= 500
 * 1 <= nums[i] <= 500
 *
 * x ^ x = 0 → XORing a number with itself cancels it out.
 * x ^ 0 = x → XORing with zero has no effect.
 */
public class DivideArrayIntoEqualPairs2206 {

    public boolean divideArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (n % 2 != 0) return false;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }

        return map.isEmpty();
    }

    public boolean divideArray1(int[] nums) {
        if (nums.length % 2 != 0) return false; // Early check

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count % 2 != 0) return false;  // Odd count = Cannot form pairs
        }

        return true;  // All counts are even, valid pairs possible
    }

    public boolean divideArrayBest(int[] nums) {
        int len = nums.length;
        int xor1=0, xor2=0;

        for(int i=0;i<len;i++){
            xor1=(nums[i]+1)^xor1;
            xor2 = nums[i]^xor2;
        }

        if(xor1 == 0 && xor2 == 0){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,2,2,2};
        DivideArrayIntoEqualPairs2206 obj = new DivideArrayIntoEqualPairs2206();
        boolean isDivideArr = obj.divideArray(arr);
        System.out.println("Result: " + isDivideArr);
    }

}
