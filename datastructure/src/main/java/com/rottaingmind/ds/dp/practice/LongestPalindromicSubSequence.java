package com.rottaingmind.ds.dp.practice;

public class LongestPalindromicSubSequence {


    public int longestPalindromeSubseq(String s) {

        return longestPalindromeSubseq(0, s.length() - 1, s);
    }

    public int longestPalindromeSubseq(int i, int j, String s) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }


        if (s.charAt(i) == s.charAt(j)) {
            return 2 + longestPalindromeSubseq(i + 1, j - 1, s);
        } else {
            return Math.max(longestPalindromeSubseq(i + 1, j, s), longestPalindromeSubseq(i, j - 1, s));
        }
    }


    public int longestPalindromeSubseqV1(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];

        return longestPalindromeSubseq(0, n - 1, s, dp);
    }

    public int longestPalindromeSubseq(int i, int j, String s, Integer[][] dp) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + longestPalindromeSubseq(i + 1, j - 1, s, dp);
        } else {
            dp[i][j] =  Math.max(longestPalindromeSubseq(i + 1, j, s, dp), longestPalindromeSubseq(i, j - 1, s, dp));
        }

        return dp[i][j];
    }

    // Bottom top
    public int longestPalindromeSubseqV2(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];

        return longestPalindromeSubseqV1(n, s, dp);
    }

    public int longestPalindromeSubseqV1(int n, String s, Integer[][] dp) {

        for (int i = 0; i <= n; i++) {
            dp[i][i]  = 1; // diagonal D0 where i == j
        }

        for (int d = 1; d <= n; d++) {
            int i = 0, j = d;
            while (i < n && j < n) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

                i++;
                j++;
            }
        }
        return dp[0][n-1];
    }

    /**
     * We use two arrays instead of dp[i][j]:
     * 1. Initialize Base Case (dp[i] =
     *  prev = [1, 1, 1, 1, 1]
     *  dp   = [1, 1, 1, 1, 1]
     *
     *  Compute Larger Subproblems Iteratively
     * Compare characters.
     * Update dp[j] using prev[j-1] or prev[j].
     *
     *  Complexity Analysis
     * ✅ Time Complexity: O(n²)
     * ✅ Space Complexity: O(n) instead of O(n²)
     */
    public int longestPalindromeSubseqSpaceLinear(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] prev = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1; // Base case (single character)
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = 2 + prev[j - 1];
                } else {
                    dp[j] = Math.max(prev[j], dp[j - 1]);
                }
            }
            prev = dp.clone(); // Update previous row
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        //bbbab

        LongestPalindromicSubSequence obj = new LongestPalindromicSubSequence();
        int res = obj.longestPalindromeSubseqSpaceLinear("bbbab"); //bbbb, cbbd -> bb
        System.out.println("LPS: " + res);
    }
}
