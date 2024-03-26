package com.rotatingmind.string;

public class PrintLongestSubString {

    /**
     * acdecfghij
     *
     * @param str
     * @return
     */
    public static String longestSubString(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }
        int len = str.length();
        int[] charFrequency;
        String minStr = "", maxStr = "";

        for (int i = 0; i < len; i++) {
            minStr = "";
            charFrequency = new int[255];

            for (int j = i; j < len; j++) {
                char nestChar = str.charAt(j);

                if (charFrequency[nestChar] > 0) {
                    break;
                } else {
                    charFrequency[nestChar] += 1;
                    minStr += nestChar;

                    if (maxStr.length() < minStr.length()) {
                        maxStr = minStr;
                    }
                }
            }
        }

        return maxStr;
    }

    public static String longestSubStringV1(String s) {
        int i = 0, j = 0;
        int len = s.length();
        int maxLen = 0;
        String longestSubstring = "";
        int[] charFrequency = new int[255];

        while (j < len) {
            char rightChar = s.charAt(j);

            if (charFrequency[rightChar] == 0) {
                charFrequency[rightChar] += 1;
                j++;
                maxLen = Math.max(maxLen, j - i);
                if (maxLen == j - i) { // Update longest substring if needed
                    longestSubstring = s.substring(i, j);
                }
            } else {
                charFrequency[s.charAt(i)] -= 1;
                i++;
            }
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        String target = "abcdcefghijiklmnopqr";
        String result = PrintLongestSubString.longestSubStringV1(target);
        System.out.println(result);
    }
}
