package com.rottaingmind.ds.greedy;

import java.util.Arrays;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 *
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 *
 * Constraints:
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 */
public class Candy135 {

    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] l2R = new int[n];
        int[] r2L = new int[n];

        Arrays.fill(l2R, 1);
        Arrays.fill(r2L, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                l2R[i] = l2R[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                r2L[i] = r2L[i + 1] + 1;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.max(l2R[i], r2L[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Candy135 obj = new Candy135();
        int[] ratings = new int[]{1, 0, 2};
        int[] ratings1 = new int[]{1, 2, 2};
        System.out.println(obj.candy(ratings1));
    }
}
