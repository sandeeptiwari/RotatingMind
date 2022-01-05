package com.rotatingmind.recursion;

public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba", 0, 4));
    }

    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        return str.charAt(start) == str.charAt(end)
                && isPalindrome(str, start + 1, end -1);
    }
}
