package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

public class LongestCommonSequenceCh11 {


    /**
     * Time & Space Complexity
     * Time Complexity:
     * <p>
     * O(m×n) (Each subproblem is solved once).
     * <p>
     * Space Complexity:
     * <p>
     * O(m×n)+O(m+n) (DP table + recursion stack).
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        Integer[][] dp = new Integer[i + 1][j + 1];
        return longestCommonSubsequence(i - 1, j - 1, text1, text2, dp);
    }

    public static int longestCommonSubsequence(int i, int j, String text1, String text2, Integer[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + longestCommonSubsequence(i - 1, j - 1, text1, text2, dp);
        } else {
            dp[i][j] = Math.max(longestCommonSubsequence(i - 1, j, text1, text2, dp), longestCommonSubsequence(i, j - 1, text1, text2, dp));
        }

        return dp[i][j];
    }

    public static int longestCommonSubsequenceV1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; // add additional row and colum for base case

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        // Define test cases
        String[][] testCases = {
                {"abcde", "ace", "3"},
                {"abc", "abc", "3"},
                {"abc", "def", "0"},
                {"", "abc", "0"},
                {"abc", "", "0"},
                {"", "", "0"},
                {"abcdefg", "aceg", "4"},
                {"AGGTAB", "GXTXAYB", "4"},
                {"a", "a", "1"},
                {"a", "b", "0"}
        };

        // Run test cases
        for (String[] testCase : testCases) {
            String text1 = testCase[0];
            String text2 = testCase[1];
            int expected = Integer.parseInt(testCase[2]);

            int result = longestCommonSubsequenceV1(text1, text2);
            System.out.println("LCS(\"" + text1 + "\", \"" + text2 + "\") = " + result +
                    " | Expected: " + expected +
                    " | " + (result == expected ? "✅ Passed" : "❌ Failed"));
        }
    }
}
