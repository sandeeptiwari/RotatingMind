package com.rotatingmind.string;

public class PermutationInAString {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "eidbaooo";

        boolean result = checkInclusion(s1, s2);
        System.out.println(result); // Output: true
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] count = new int[26]; // Assuming input strings only contain lowercase letters

        // Count the frequency of characters in s1
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, remaining = s1.length();

        // Initialize the sliding window
        while (right < s2.length()) {
            // Expand the window to the right
            if (count[s2.charAt(right++) - 'a']-- >= 1) {
                remaining--;
            }

            // Check if the window size matches s1 length
            if (remaining == 0) {
                return true;
            }

            // Shrink the window from the left if it exceeds s1 length
            if (right - left == s1.length() && count[s2.charAt(left++) - 'a']++ >= 0) {
                remaining++;
            }
        }
        return false;
    }
}

