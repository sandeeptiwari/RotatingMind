package com.rotatingmind.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * You have been given the string s (which consists of only uppercase English characters) and the integer k.
 * You can replace any character in the string with another uppercase English character.
 * This operation can be performed at most k times. After executing the preceding procedures, return the length of
 * the longest substring containing the same letter.
 * String s = AABABBA, k = 1
 */
public class MaxSubString {


    /**
     * Time complexity: O(n)O(n)O(n) because it is a sliding window problem and we must go through the array only once.
     *
     * Space complexity: O(1)O(1)O(1) because we used a constant space by working with an array of 26 spaces which is fixed and independent of the input string ‘s’.
     * @param s
     * @param k
     * @return
     */
    public static int maxLenOfSubString(String s, int k) {
        // Initialising an empty array to store the count of the
        // characters in the given string s
        int[] arr = new int[26];
        int res = 0;
        int max = 0;

        // The left pointer for the sliding window is l AND r is the
        // right pointer
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // Counting the number of each character in the string s
            arr[s.charAt(r) - 'A']++;

            // Checking the character with max number of occurrence
            max = Math.max(max, arr[s.charAt(r) - 'A']);

            // Now we check if our current window is valid or not
            if (r - l + 1 - max > k) {
                // this means the no. of replacements is more than
                // allowed (k)
                // Decrementing the count of the character which was
                // at l because it is no longer in the window
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(maxLenOfSubString("AABABBA", 1));
        //System.out.println(maxLenOfSubString("ABAB", 2));
        //System.out.println(maxLenOfSubString("AAAA", 2));
        //System.out.println(maxLenOfSubString("ABAA", 0));
    }
}
