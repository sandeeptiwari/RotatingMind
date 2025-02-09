package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

/**
 * 0/1 Knapsack is important problem for dynamic programming study since it provides many useful insights.
 *
 *
 * Statement: Given a set of n items numbered from 1 up to n, each with a weight wi and a value vi, along with a maximum weight capacity W,
 * maximize the sum of the values of the items in the knapsack so that the sum of the weights is less than or equal to the knapsack's capacity.
 *
 *
 * Naive Solution:
 * Lets see naive solution - there are only 2 choices for each item, either to include in knapsack or ignore the item.
 * If item is included then check for remaining items (N - 1) by decreasing capacity W - vi and accumulating value of item. Else, check for remaining
 * items (N - 1) without change in capacity and value. Again, each next item will have two choices.
 * If you visualise as tree it would something like below decision tree:
 *
 *
 */
public class KnapSackCh9 {

    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        return knapSackHelper(wt.length - 1, capacity, val, wt);
    }

    static int knapSackHelper(int index, int capacity, int val[], int wt[]) {
        // Base case: No items left or capacity is zero
        if (index < 0 || capacity == 0) {
            return 0;
        }

        // If the current item's weight is greater than remaining capacity, skip it
        if (wt[index] > capacity) {
            return knapSackHelper(index - 1, capacity, val, wt);
        }

        // Two choices: include or exclude the current item
        int include = val[index] + knapSackHelper(index - 1, capacity - wt[index], val, wt);
        int exclude = knapSackHelper(index - 1, capacity, val, wt);

        // Return the maximum value
        return Math.max(include, exclude);
    }



    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack1(int capacity, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][capacity + 1];
        Arrays.fill(dp, -1);
        return knapSackHelper(n - 1, capacity, val, wt);
    }


    public static void main(String[] args) {
        int[] values = {6, 10, 12};
        int[] weights = {1, 2, 3};
        int capacity = 5;
        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                dp[i][j] = -1;
            }
        }

        int maxProfit = knapSackHelper(n - 1, capacity, values, weights, dp);
        System.out.println("Maximum value: " + maxProfit); // Output: 22
    }


    static int knapSackHelper(int index, int capacity, int[] val, int[] wt, int[][] dp) {
        // Base case: No items left or capacity is zero
        if (index < 0 || capacity == 0) {
            return 0;
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        // If the current item's weight is greater than remaining capacity, skip it
        if (wt[index] > capacity) {
            return dp[index][capacity] = knapSackHelper(index - 1, capacity, val, wt);
        }

        // Two choices: include or exclude the current item
        int include = val[index] + knapSackHelper(index - 1, capacity - wt[index], val, wt);
        int exclude = knapSackHelper(index - 1, capacity, val, wt);

        // Return the maximum value
        dp[index][capacity] = Math.max(include, exclude);

        return dp[index][capacity];
    }


}
