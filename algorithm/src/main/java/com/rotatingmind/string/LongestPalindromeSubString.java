package com.rotatingmind.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class LongestPalindromeSubString {

    // https://leetcode.com/problems/longest-palindromic-substring
        int resultStart;
        int resultLength;

        public String longestPalindrome(String s) {
            int strLength = s.length();
            if (strLength < 2) {
                return s;
            }
            for (int start = 0; start < strLength - 1; start++) {
                expandRange(s, start, start);
                expandRange(s, start, start + 1);
            }
            return s.substring(resultStart, resultStart + resultLength);
        }

        private void expandRange(String str, int begin, int end) {
            while (begin >= 0 && end < str.length() &&
                    str.charAt(begin) == str.charAt(end)) {
                begin--;
                end++;
            }
            if (resultLength < end - begin - 1) {
                resultStart = begin + 1;
                resultLength = end - begin - 1;
            }
        }


    public String longestPalindromeV2(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //StringBuffer sb = new StringBuffer();
            //sb.append(s.charAt[i]);
            char c = s.charAt(i);
            int left = i;
            int right = i;

            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }

            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }


            // left + 1 and right - 1 are actually the start and end index of the Palindromic string
            // we don't set "right" because String.substring function required end index exclusively
            left = left + 1;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }

        return s.substring(start, end);
    }

    /**
     * window : start is 0 and end is string's length
     * check if this is a palindrome , if not reduce the window length by decreasing end
     * position.
     * if a palindrome is found , store the length and the string.
     * Increment start position and repeat from step 2 ,
     * if window becomes smaller than the palindrome found in the previous step ,
     * break the loop
     * @param args
     */

    public String longestPalindromeV3(String s) {
        int start = 0;
        int end = s.length() - 1;
        int len = Integer.MIN_VALUE;

        int start2 = 0;

        String res = "";
        while (start <= s.length() - 1) {

            while (start2 <= end) {
                if (isPalindrome(s, start2, end)) {
                    // we already have a palindrome of greater length
                    if (len >= (end - start2 + 1)) {
                        break;
                    }

                    res = s.substring(start2, end + 1);
                    len = end - start2 + 1;
                    break;
                }
                end--;
            }
            start2 = start + 1;
            start++;
            end = s.length() - 1;
        }

        return res;
    }
    boolean isPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
    public static void main(String[] args) {
        int len = longestPalindromeV4("abccccdd");
        System.out.println(len);
    }



    public static int longestPalindromeV4(String s) {
        int oddCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) % 2 == 1)
                oddCount++;
            else
                oddCount--;
        }
        if (oddCount > 1)
            return s.length() - oddCount + 1;
        return s.length();
    }



}
