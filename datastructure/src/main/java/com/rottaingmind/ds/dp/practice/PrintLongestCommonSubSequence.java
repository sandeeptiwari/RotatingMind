package com.rottaingmind.ds.dp.practice;

public class PrintLongestCommonSubSequence {

    private void printLongestCommonSubSequence(String s1, String s2) {
        StringBuilder sb = new StringBuilder();

        int i = s1.length();
        int j = s2.length();

        int [][] dp = longestCommonSubsequence(s1, s2);

        while(i > 0 && j > 0) { 
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

     if (!sb.isEmpty()) {
         System.out.println(sb.reverse().toString());
     }
  }

    public static int[][] longestCommonSubsequence(String text1, String text2) {
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

        return dp;
    }

    public static void main(String[] args) {
        PrintLongestCommonSubSequence obj = new PrintLongestCommonSubSequence();
        obj.printLongestCommonSubSequence("ABCDGH", "AEDFHR"); //ADH
        //“” and “” is “”
        obj.printLongestCommonSubSequence("AGGTAB", "GXTXAYB"); //GTAB
    }
}
