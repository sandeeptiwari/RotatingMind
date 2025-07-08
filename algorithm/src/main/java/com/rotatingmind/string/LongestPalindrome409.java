package com.rotatingmind.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
public class LongestPalindrome409 {

    public int longestPalindrome(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.compute(s.charAt(i), (k, v) -> v != null ? 1 : ++v);
        }

        Map<Boolean, List<Integer>> charsCounts = map.values().stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));

        return charsCounts.get(true).stream().reduce(0, Integer::sum) + (charsCounts.get(false).isEmpty() ? 0 : 1);
    }

    public int longestPalindrome1(String s) {
        int n = s.length();
        int oddFreq = 0;
        int result = 0;
        Set<Character> seen = new HashSet<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(seen.contains(ch)) {
                result += 2;
                oddFreq--;
                seen.remove(ch);
            } else {
                seen.add(ch);
                oddFreq++;
            }
        }

        return result + (oddFreq > 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        LongestPalindrome409 obj = new LongestPalindrome409();
        int res = obj.longestPalindrome1("abccccdd");
        System.out.println("Result is " + res);
    }

}
