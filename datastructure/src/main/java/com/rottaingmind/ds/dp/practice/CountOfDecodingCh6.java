package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

public class CountOfDecodingCh6 {

    private int countOfDecoding(String encodeStr) {
        int [] dp = new int[encodeStr.length()];
        Arrays.fill(dp,-1);
        return countOfDecoding(0, encodeStr, dp);
    }

    private int countOfDecoding(int i, String encodeStr, int [] dp) {

        if (i >= encodeStr.length()) {
            return 1; //Correct Base Case: If i == encodeStr.length(), return 1 because reaching the end means we found a valid decoding.
        }

        if (encodeStr.charAt(i) == '0') {
            return 0; // Leading zero is not a valid encoding
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = 0;

        char ch = encodeStr.charAt(i);
        if (isValid(ch - '0', 1)) {
            ans += countOfDecoding(i + 1, encodeStr, dp);
        }
        if (i < encodeStr.length() - 1 && isValid((ch - '0') * 10 + encodeStr.charAt(i + 1) - '0', 2)) {
            ans += countOfDecoding(i + 2, encodeStr, dp);
        }
        dp[i] = ans;

        return ans;
    }

    private boolean isValid(int code, int n) {
        if (n == 1) {
            return code >= 1 && code <= 9;
        }
        return code >= 10 && code <= 26;
    }




    public static void main(String[] args) {
        CountOfDecodingCh6 decoder = new CountOfDecodingCh6();



        System.out.println(decoder.countOfDecoding("12")); // Output: 2 ("AB", "L")
        System.out.println(decoder.countOfDecoding("226")); // Output: 3 ("BZ", "VF", "BBF")
        System.out.println(decoder.countOfDecoding("06")); // Output: 0 (invalid)
        System.out.println(decoder.countOfDecoding("11106")); // Output: 2 ("AAJF", "KJF")
        System.out.println(decoder.countOfDecoding("27")); // Output: 1 ("BG")
        System.out.println(decoder.countOfDecoding("2324")); // Output: 4 ("BG")
    }
}
