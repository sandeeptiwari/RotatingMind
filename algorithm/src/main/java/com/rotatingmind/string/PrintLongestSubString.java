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
        int left = 0, right = 0;
        int n = s.length();
        int maxLen = 0;
        String longestSubstring = "";
        int[] charFrequency = new int[255];

        while (right < n) {
            char rightChar = s.charAt(right);

            if (charFrequency[rightChar] == 0) {
                charFrequency[rightChar] += 1;
                right++;
                maxLen = Math.max(maxLen, right - left);
                if (maxLen == right - left) { // Update longest substring if needed
                    longestSubstring = s.substring(left, right);
                }
            } else {
                charFrequency[s.charAt(left)] -= 1;
                left++;
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
