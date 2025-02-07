package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

public class StairCaseCha2 {


    public int totalWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return totalWays(n - 1) + totalWays(n - 2);
    }


    /**
     * Why return 1 when n == 0?
     * This condition is used to count valid ways to reach the top of the staircase. Let me explain step by step.
     *
     * Understanding the problem:
     * You can take 1 step or 2 steps at a time. The number of ways to reach step n is:
     *
     * 𝑓
     * (
     * 𝑛
     * )
     * =
     * 𝑓
     * (
     * 𝑛
     * −
     * 1
     * )
     * +
     * 𝑓
     * (
     * 𝑛
     * −
     * 2
     * )
     * f(n)=f(n−1)+f(n−2)
     * Now, let's analyze what happens when n == 0.
     *
     * Think of n as "remaining steps"
     * If n == 0, it means we have exactly reached the top.
     * This counts as one valid way of reaching the destination.
     * So, we return 1 because this path is a successful way to reach n = 0.
     * Think of n < 0
     * If n < 0, it means we took too many steps and overshot the destination.
     */
    public static int totalWaysV1(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n]  = totalWaysV1(n - 1, dp) + totalWaysV1(n - 2, dp);

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); // Initialize dp array with -1

        System.out.println("Total ways to reach " + n + ": " + totalWaysV1(n, dp));
    }
}
