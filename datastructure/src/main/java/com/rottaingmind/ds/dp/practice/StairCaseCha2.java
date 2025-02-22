package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;
import java.util.Map;

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
     * f(n)=f(n−1)+f(n−2)
     *
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


    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);  // Fill with -1 to indicate uncomputed states
        return Math.min(minCostClimbingStairs(n - 1, cost, dp), minCostClimbingStairs(n - 2, cost, dp));
    }

    public static int minCostClimbingStairs(int i, int[] cost, int[] dp) {
        if (i == 0) return cost[0];
        if (i == 1) return cost[1];

        if (dp[i] != -1) return dp[i];  // Return already computed value

        int oneStep = minCostClimbingStairs(i - 1, cost, dp);
        int twoStep = minCostClimbingStairs(i - 2, cost, dp);

        dp[i] =  cost[i] + Math.min(oneStep, twoStep);

        return dp[i];
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[n -1], dp[n-2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i <= n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); // Initialize dp array with -1

        int[] a = {10,15,20};

       // System.out.println("Total ways to reach " + n + ": " + totalWaysV1(n, dp));
        System.out.println("Total ways to reach " + n + ": " + minCostClimbingStairs(a));

        int[] b = {1,100,1,1,1,100,1,1,100,1};
        System.out.println("Total ways to reach " + n + ": " + minCostClimbingStairs(b));


        //int[] cost = {10, 15, 20};
        //int n = cost.length;

        // Min cost to reach the top can be from n-1 or n-2 (top step can be reached in two ways)
       // int result = Math.min(minCostClimbingStairs(n - 1, cost), minCostClimbingStairs(n - 2, cost));

      //  System.out.println(result); // Output: 15*/
    }
}
