package com.rotatingmind.array;

import java.util.*;

/**
 * Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d
 * where a, b, c, and d are elements of nums, and a != b != c != d.
 *
 * Input: nums = [2,3,4,6]
 * Output: 8
 * Explanation: There are 8 valid tuples:
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 */
public class TupleWithSameProduct {


    /**
     *  Step-by-Step Solution:
     * Step 1: Calculate Products of All Pairs
     * Loop through all possible pairs (i, j) in nums.
     * Store the product as a key and the pairs as values in a map.
     * Step 2: Count Tuples for Same Products
     * If multiple pairs have the same product, count how many combinations of these pairs can form tuples.
     * If a product occurs k times, the number of valid tuple combinations is:
     * Total Tuples

     * Total Tuples=k×(k−1)×4
     * (Each pair can be arranged in 4 ways — swapping a,b and c,d)
     * @return
     */
    record Tupple(int x, int y) {}

    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> productCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                var product = nums[i] * nums[j];
                if (!productCount.containsKey(product)) {
                    productCount.put(product, productCount.getOrDefault(product, 0) + 1);
                }
            }
        }
        int totalTuples = 0;
        for (Map.Entry<Integer, Integer> entry : productCount.entrySet()) {
            var k = entry.getValue();
            if (k > 1) {
                var tuples = k * (k - 1) * 4;
                totalTuples += tuples;
            }
        }

      return totalTuples;
    }

    private void allPermutations(List<Integer> prefix, int[] nums, boolean[] used,
                                 List<List<Integer>> result, Set<String> seen) {
        if (prefix.size() == nums.length) {
            String key = prefix.toString();
            if (!seen.contains(key)) {
                result.add(new ArrayList<>(prefix));
                seen.add(key);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            prefix.add(nums[i]);

            allPermutations(prefix, nums, used, result, seen);

            // Backtrack
            used[i] = false;
            prefix.remove(prefix.size() - 1);
        }
    }

}
