package com.rotatingmind.array.binarysearch_usage;

import java.util.Arrays;

/**
 * You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i].
 * You can divide each pile into any number of sub piles, but you cannot merge two piles together.
 *
 * You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies.
 * Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.
 *
 * Return the maximum number of candies each child can get.
 *
 * Input: candies = [5,8,6], k = 3
 * Output: 5
 * Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. We now have five piles of
 * candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.
 */
public class MaxCandiesToKChildrens2226 {


    /**
     * If total portions >= k, it means mid candies can be a valid answer — so move left to mid + 1.
     */
    public boolean isAllocationPossible(int[] candies, int mid, long k) {
        return Arrays.stream(candies).map(candi -> candi / mid).asLongStream().sum() >= k;
    }

    /**
     * Binary search explores valid values and narrows the range. When the loop ends,
     * low overshoots the maximum valid size, but high remains the correct answer.
     */
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = Arrays.stream(candies).max().orElse(0);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isAllocationPossible(candies, mid, k)) {
                low = mid + 1;   // Try a larger portion size
            } else {
                high = mid - 1;  // Try a smaller portion size
            }
        }
        return high;  // Maximum valid portion size
    }

    public static void main(String[] args) {
        MaxCandiesToKChildrens2226 obj = new MaxCandiesToKChildrens2226();
        // Test cases
        int[][] testCases = {
                {5, 8, 6},       // Typical case
                {1, 2, 3, 4},    // Small numbers
                {1000000000, 1}, // Max limit case
                {7, 11, 13, 17}, // Prime numbers
                {1, 1, 1, 1, 1}, // All minimum values
                {100, 100, 100}, // All maximum values within reasonable range
                {9, 9, 9, 9},    // Identical values
                {0, 0, 0},        // All zeros
                {5, 0, 5},        // Mixed zero values
                {1000000},        // Single large value
        };

        long[] kValues = {3, 5, 1, 5, 5, 4, 8, 1, 2, 1};
        int[] expectedResults = {5, 2, 1000000000, 3, 1, 100, 4, 0, 5, 1000000};

        for (int i = 0; i < testCases.length; i++) {
            int result = obj.maximumCandies(testCases[i], kValues[i]);
            System.out.printf("Test Case %d: Expected %d, Got %d -> %s\n",
                    i + 1, expectedResults[i], result,
                    result == expectedResults[i] ? "PASS" : "FAIL");
        }
    }
}
