package com.rottaingmind.ds.dp.practice;

public class TimeTheLaneCha3 {

    static final int MOD = 1_000_000_007;

    //Time Limit Exceeded
    public int numTilings1(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5; // Base case

        return (2 * numTilings(n - 1) % MOD + numTilings(n - 3) % MOD) % MOD;  // Apply MOD
    }

    public int numTilings(int n) {
        return helper(n, new int[n + 1]);  // Pass DP array for memoization
    }

    private int helper(int n, int[] dp) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        if (dp[n] != 0) return dp[n];  // Memoization check

        dp[n] = ((2 *  helper(n - 1, dp)) % MOD + helper(n - 3, dp) % MOD)  % MOD;  // Apply MOD
        return dp[n];
    }

    public int numTilings2(int n) {
        // Initialize a DP array to store tiling counts for 4 states
        // f[0]: full covering, f[1]: top row is missing, f[2]: bottom row is missing, f[3]: transitional state (both rows are missing)
        long[] dp = {1, 0, 0, 0};

        // Modulo value to prevent overflow
        int mod = (int) 1e9 + 7;

        // Iterate over the sequence from 1 to n
        for (int i = 1; i <= n; ++i) {
            // Temporary array to hold the new states counts
            long[] newDp = new long[4];

            // New full covering can be achieved from any previous state
            newDp[0] = (dp[0] + dp[1] + dp[2] + dp[3]) % mod;

            // New top missing can be achieved from state when previously bottom was missing and the transitional state
            newDp[1] = (dp[2] + dp[3]) % mod;

            // New bottom missing can be achieved from state when previously top was missing and the transitional state
            newDp[2] = (dp[1] + dp[3]) % mod;

            // New transitional state comes solely from previous full covering state
            newDp[3] = dp[0];

            // Update the dp array for the next iteration
            dp = newDp;
        }

        // After completing all iterations, the count of fully covered tilings is in dp[0]
        return (int) dp[0];
    }
}
