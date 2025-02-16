package com.rotatingmind.string.practice;

public class CustomContains {


    public static boolean exist(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int j = 0;
        for (int i = 0; i < n; ) {
            for (j = 0; j < m; ) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                }else {
                    i++;
                    break;
                }
            }
            if (j == m) {
                return true;
            }
        }

        return j == m;
    }


    public static int indexOfStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return -1; // Edge case: Empty needle
        if (n < m) return -1; // Needle is longer than haystack
        if (haystack.equals(needle)) return 0; // Exact match case

        char first = needle.charAt(0);

        int diff = n - m;

        for (int i = 0; i <= diff; i++) {

            if (first != haystack.charAt(i)) {
                while (++i <= diff  && haystack.charAt(i) != first);
            }

            if (i <= diff) {
                int j = i + 1;
                int  k = 1;
                while (k < m && haystack.charAt(j) == needle.charAt(k)) {
                    j++;
                    k++;
                }
                if (k == m) return i; // If full match found
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static int indexOfStr1(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return -1; // Edge case

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) return i; // Found the match
        }
        return -1; // No match found
    }

    public static void main12(String[] args) {
        System.out.println(indexOfStr("Sandeep", "and"));
        System.out.println(indexOfStr("hello", "ll"));
        System.out.println(indexOfStr("mississippi", "a"));
        System.out.println(indexOfStr("abc", "c"));
        System.out.println(indexOfStr("aaaaa", "bba"));
        System.out.println(indexOfStr("aaaaa", "baaa"));
        System.out.println(indexOfStr("mississippi", "pi"));
        //System.out.println("mississippi".indexOf("a"));
    }


    /**
     * Implement an algotihm to determine if a string has all unique characters. What if you cannot use additional data structures ?
     */
    public static boolean isUnique(String str) {
        int n = str.length();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isUnique1(String str) {
        int n = str.length();
        int[] chars = new int[256];

        for (int i = 0; i < n; i++) {
            chars[str.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            if (chars[str.charAt(i)] > 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean isUnique2(String str) {
        if (str.length() > 256) return false; // More characters than possible unique values

        boolean[] chars = new boolean[256];

        for (char c : str.toCharArray()) {
            if (chars[c]) return false;
            chars[c] = true;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isUnique1("Sandeep"));
        System.out.println(isUnique1("hello"));
        System.out.println(isUnique1("mississippi"));
        System.out.println(isUnique1("abc"));
        System.out.println(isUnique1("aaaaa"));
        System.out.println(isUnique1("aaaaa"));
        System.out.println(isUnique1("mississippi"));
        //System.out.println("mississippi".indexOf("a"));
    }


}
