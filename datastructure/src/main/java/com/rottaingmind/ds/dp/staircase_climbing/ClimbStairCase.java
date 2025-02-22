package com.rottaingmind.ds.dp.staircase_climbing;

import java.util.Arrays;

public class ClimbStairCase {

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairs(n, dp);
    }

    public static int climbStairs(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);

        return dp[n];
    }

    public static int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

       for (int i = 2; i <= n; i++) {
           dp[i] = dp[i - 1] + dp[i - 2];
       }
        return dp[n];
    }

    /**
     * Why This Works
     * prev2 stores f(n-2)
     * prev1 stores f(n-1)
     * At each step, we calculate f(n) = f(n-1) + f(n-2), then shift prev2 and prev1 forward.
     * Example Walkthrough (n = 5)
     *
     * i	prev2 (f(n-2))	prev1 (f(n-1))	curr = prev1 + prev2
     * 2	1	             1	                   2
     * 3	1	             2	                   3
     * 4	2	             3	                   5
     * 5	3	             5	                   8
     */
    public static int climbStairs2(int n) {
        if (n == 1) return 1;  // Base case for n=1

        int prev2 = 1; // f(1)
        int prev1 = 1; // f(2)

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;  // Move prev2 forward
            prev1 = curr;   // Move prev1 forward
        }
        return prev1;  // prev1 now holds f(n)
    }


    public static void main(String[] args) {
        System.out.println(climbStairs2(2));
        System.out.println(climbStairs2(3));
    }

}
