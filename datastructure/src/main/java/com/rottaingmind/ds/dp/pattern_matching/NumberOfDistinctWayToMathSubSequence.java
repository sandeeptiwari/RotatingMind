package com.rottaingmind.ds.dp.pattern_matching;

public class NumberOfDistinctWayToMathSubSequence {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        Integer [][] dp = new Integer[n][m];
        return numDistinct(n -1, m-1, s, t, dp);
    }

    public int numDistinct(int i, int j, String s, String t, Integer [][] dp) {
        if (j < 0) return 1; // If t is empty, there is 1 valid subsequence (empty string)
        if (i < 0) return 0; // If s is empty but t is not, no subsequence is possible

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = numDistinct(i - 1, j - 1, s, t, dp) + numDistinct(i - 1, j, s, t, dp);
        } else {
            dp[i][j] = numDistinct(i - 1, j, s, t, dp);
        }

        return dp[i][j];
    }
}
