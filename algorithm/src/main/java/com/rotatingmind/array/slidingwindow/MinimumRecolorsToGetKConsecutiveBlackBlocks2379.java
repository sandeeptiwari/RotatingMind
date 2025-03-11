package com.rotatingmind.array.slidingwindow;

/**
 * You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block.
 * The characters 'W' and 'B' denote the colors white and black, respectively.
 *
 * You are also given an integer k, which is the desired number of consecutive black blocks.
 *
 * In one operation, you can recolor a white block such that it becomes a black block.
 *
 * Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
 *
 * Example 1:
 *
 * Input: blocks = "WBBWWBBWBW", k = 7
 * Output: 3
 * Explanation:
 * One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
 * so that blocks = "BBBBBBBWBW".
 * It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
 * Therefore, we return 3.
 *
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks2379 {

    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int count = 0;

        // Count the number of 'W's in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
        }

        int minCount = count;

        // Sliding window logic
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i) == 'W') count++;
            if (blocks.charAt(i - k) == 'W') count--;
            minCount = Math.min(minCount, count);
        }

        return minCount;
    }

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println("Result :: " + minimumRecolors(blocks, k));
    }
}
