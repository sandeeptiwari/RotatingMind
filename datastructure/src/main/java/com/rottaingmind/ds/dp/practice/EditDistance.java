package com.rottaingmind.ds.dp.practice;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        Integer[][] dp = new Integer[n][m];

        return minDistance(n-1, m-1, word1, word2, dp);
    }

    public int minDistance(int i, int j, String word1, String word2, Integer[][] dp) {
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = minDistance(i-1, j-1, word1, word2, dp);
        } else {
            dp[i][j] = 1 + Math.min(minDistance(i-1, j-1, word1, word2, dp), Math.min(minDistance(i, j-1, word1, word2, dp), minDistance(i-1, j, word1, word2, dp)));
        }

        return dp[i][j];
    }


    /**
     * Input: word1 = "horse", word2 = "ros"
     * Output: 3
     * Explanation:
     * horse -> rorse (replace 'h' with 'r')
     * rorse -> rose (remove 'r')
     * rose -> ros (remove 'e')
     */
    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        int res = obj.minDistance("horse", "ros");
        System.out.println("Result: " + res);
    }
}
