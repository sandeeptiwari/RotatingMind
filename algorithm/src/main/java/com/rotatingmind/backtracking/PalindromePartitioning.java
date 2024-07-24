package com.rotatingmind.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 *Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        util(s, 0, ans, res);
        return res;

    }


    public void util(String s, int i, List<String> ans, List<List<String>> res) {

        if (i == s.length()) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s.substring(i, j + 1))) {
                ans.add(s.substring(i, j + 1));
                util(s, j + 1, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String s) {

        int i = 0;

        int j = s.length() - 1;

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {

                return false;

            }

            i++;

            j--;

        }

        return true;

    }
}
