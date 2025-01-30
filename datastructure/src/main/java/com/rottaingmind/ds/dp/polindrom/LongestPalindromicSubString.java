package com.rottaingmind.ds.dp.polindrom;

import java.util.Arrays;

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 * Why Length 2 Breaks This Formula:
 *
 * For a length-2 substring (i, j such that j = i + 1), i + 1 > j - 1, so isPalindrome[i + 1][j - 1] doesn't make sense.
 * Example:
 * For s = "ab", checking s[0..1] ("ab") using the general formula:
 * java
 * Copy
 * Edit
 * isPalindrome[0][1] = (s.charAt(0) == s.charAt(1) && isPalindrome[1][0]);
 * isPalindrome[1][0] is invalid because i > j.
 * How to Handle Length-2 Substrings:
 *
 * For length-2 substrings, we directly check if the two characters are equal:
 * java
 * Copy
 * Edit
 * isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
 * No need to check a "middle substring" because there isn't one.
 * Example:
 * For s = "aa", directly check if s[0] == s[1] ('a' == 'a' → true).
 * Special Case for Length 2 Is Needed:
 *
 * The separate handling of 2-character substrings is necessary because the general formula doesn't work for such cases.
 * Without this special case, you will skip or incorrectly mark some substrings as non-palindromes.
 */
public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {
        int n = s.length();

        if (n == 0) return "";
        if(n == 1) return s;

        boolean [][] isPal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            isPal[i][i] = true;
        }

        int start = 0;
        int maxLen = 1;

        for(int i = 0; i < n - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                isPal[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for(int len = 3; len <= n ; len++) {
            for(int i = 0; i <  n - len + 1; i ++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1]) {
                    isPal[i][j] = true;

                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }

            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * start = i - (len - 1) / 2;
     * is used to calculate the starting index of the longest palindrome substring found during the iteration. Let me break it down step-by-step with an example.
     *
     * What this line does:
     * i is the center index of the palindrome (or one of the centers in case of even-length palindromes).
     * len is the length of the palindrome substring found.
     * The formula i - (len - 1) / 2 calculates the starting index of the palindrome by adjusting for the position of the leftmost character in the palindrome.
     * Why i - (len - 1) / 2?
     * Odd-length palindromes:
     * For odd-length palindromes, the center is exactly at index i. The length of the palindrome is len, so to find the leftmost index (the start index) of the palindrome, we subtract (len - 1) / 2 from
     * @param s
     * @return
     */
    public String longestPalindromeV1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        int start = 0;  // To store the starting index of the longest palindrome
        int maxLength = 1;  // Maximum length of the palindrome found

        for (int i = 0; i < n; i++) {
            // Check for odd-length palindromes (centered at i)
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindromes (centered between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);

            // Find the longer palindrome from the two
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        // Return the longest palindrome substring
        return s.substring(start, start + maxLength);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }



    public static void main(String[] args) {
        LongestPalindromicSubString lp = new LongestPalindromicSubString();

        // Test cases
       /* System.out.println(lp.longestPalindrome("babad")); // Expected: "bab" or "aba"
        System.out.println(lp.longestPalindrome("cbbd"));  // Expected: "bb"
        System.out.println(lp.longestPalindrome("a"));     // Expected: "a"
        System.out.println(lp.longestPalindrome(""));      // Expected: ""
        System.out.println(lp.longestPalindrome("ac"));    // Expected: "a" or "c"
        System.out.println(lp.longestPalindrome("aaaa"));  // Expected: "aaaa"
        System.out.println(lp.longestPalindrome("abcda")); // Expected: "a"
        System.out.println(lp.longestPalindrome("aabbaa"));// Expected: "aabbaa"*/

        System.out.println(lp.longestPalindrome("ac"));    // Expected: "a" or "c"
    }
}
