package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

/**
 * Your original approach has exponential time complexity → Not feasible for large N.
 * Adding memoization (top-down DP) reduces redundant calculations → O(N * C) time, O(N) space.
 * Bottom-up DP (tabulation) is more efficient → Same O(N * C) time but avoids recursion overhead.
 * For large values of N, always prefer bottom-up dynamic programming.
 *
 * Time Complexity: O(N * C) (better than exponential recursion).
 * Space Complexity: O(N) (no recursion stack, just an array).
 */
public class CoinChangeCh8 {

   /* Problem with below: Long.MAX_VALUE + 1 Causes Overflow
      Let’s assume:
      int[] coins = {2, 3, 7};
      int N = 5;

        Step-by-Step Breakdown
        Recursive calls and values returned:
        minCoins(5)

        Calls minCoins(3), minCoins(2), minCoins(-2)
        minCoins(3)

        Calls minCoins(1), minCoins(0), minCoins(-4)
        minCoins(1)

        Calls minCoins(-1), minCoins(-2), minCoins(-6)
        minCoins(-2), minCoins(-4), etc. → Returns Long.MAX_VALUE

        ans = 1 + Long.MAX_VALUE
        Problem: Long.MAX_VALUE + 1 causes integer overflow.

        Long.MAX_VALUE + 1 == -9223372036854775808 (overflowed value)

        Sol: if (N < 0) return Integer.MAX_VALUE - 1;



   private long minCoins(int[] coins, int N) {
        if (N < 0) return Long.MAX_VALUE;
        if (N == 0) return 0;

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            ans = Math.min(ans, 1 + minCoins(coins, N - coins[i]));
        }

        return ans;
    }*/

    private int[] dp;

    public int minCoins(int[] coins, int N) {
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return helper(coins, N);
    }

    private int helper(int[] coins, int N) {
        if (N < 0) return Integer.MAX_VALUE - 1; // Prevent overflow
        if (N == 0) return 0;
        if (dp[N] != -1) return dp[N];

        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            ans = Math.min(ans, 1 + helper(coins, N - coin));
        }
        return dp[N] = ans;
    }

    public int minCoinsBottomUp(int[] coins, int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[N] == Integer.MAX_VALUE - 1 ? -1 : dp[N]; // Handle no solution case
    }

    public static void main(String[] args) {
        CoinChangeCh8 cc = new CoinChangeCh8();
        int[] coins = {1, 2, 5};
        int N = 11;
        System.out.println(cc.minCoins(coins, N)); // Output: 3 (5+5+1)
    }

}
