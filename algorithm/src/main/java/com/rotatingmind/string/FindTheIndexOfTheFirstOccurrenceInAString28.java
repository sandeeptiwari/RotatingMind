package com.rotatingmind.string;

public class FindTheIndexOfTheFirstOccurrenceInAString28 {

    public int strStr(String haystack, String needle) {
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
}
