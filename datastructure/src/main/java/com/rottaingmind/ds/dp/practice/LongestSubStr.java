package com.rottaingmind.ds.dp.practice;

public class LongestSubStr {

    public static String longestPalindrome(String s) {

        int n = s.length();

        if (n == 0 || n == 1) return s;
        if (n == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }

        }

        Boolean[][] isPali = new Boolean[n][n];

        int ans = 1;
        int start = -1;
        int end = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i > j || i == j) {
                    isPali[i][j] = true;
                } else {
                    isPali[i][j] = null;
                }
            }
        }

        for(int d = 1; d < n; d++) {
            int i = 0, j = d;
            while(i < n && j < n) {

                isPali[i][j] = s.charAt(i) == s.charAt(j) && isPali[i + 1][j - 1];

                if (isPali[i][j]) {
                    ans = Math.max(ans, j - i + 1);
                    start = i;
                    end = j;
                }
                i++;
                j++;
            }
        }

        return start == -1 ? "" : s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        String s = "abcda";
        System.out.println(longestPalindrome(s));
    }
}
