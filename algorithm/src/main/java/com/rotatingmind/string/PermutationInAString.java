package com.rotatingmind.string;

public class PermutationInAString {

    public static void main11(String[] args) {
        String s1 = "abnc";
        String s2 = "cab";

        boolean result = isPermutation(s1, s2);
        System.out.println(result); // Output: true
    }

    public static boolean isPermutation(String s1, String s2) {
        int N = s1.length();
        int[] chars = new int[26];
        for (int i = 0; i < N; i++) {
            chars[s1.charAt(i) - 'a']++;
        }

        int remain = s2.length();

        for (int i = 0; i < s2.length(); i++) {
            int ch = chars[s2.charAt(i) - 'a'];
            if (ch >= 1) {
                chars[s2.charAt(i) - 'a']--;
                remain--;
            }
        }
        return remain == 0;
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



    public static boolean isPermutation1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] chars = new int[26]; // Array for 'a' to 'z'

        for (char c : s1.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            chars[c - 'a']--;
            if (chars[c - 'a'] < 0) return false; // Extra character in s2
        }

        return true;
    }


    /**
     * Sliding Window (O(n))	O(n)	O(1)	Most efficient & elegant	No
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isPermutation2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int m = s1.length();
        int n = s2.length();

        int[] s1Count = new int[26]; // Array for 'a' to 'z'
        int[] s2Count = new int[26]; // Array for 'a' to 'z'

        for (int i = 0; i < m; i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= n - m; i++) {
            s2Count[s2.charAt(i) - 'a']++;

            if (i >= m) {
                s2Count[s2.charAt(i - m) - 'a']--;
            }

            if (match(s1Count, s2Count)) return true;
        }

        return false;
    }

    private static boolean match(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(isPermutation2(s1, s2));
    }
}

