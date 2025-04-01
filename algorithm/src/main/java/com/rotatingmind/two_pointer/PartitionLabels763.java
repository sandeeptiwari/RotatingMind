package com.rotatingmind.two_pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 */
public class PartitionLabels763 {

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();

        int i = 0;

        while (i < n) {
            int window = map.get(s.charAt(i));
            int j = i;

            while(j < window) {
                int currWindow = map.get(s.charAt(j));
                window = Math.max(currWindow, window);
                j++;
            }

            result.add(j - i + 1);
            i = j + 1;
        }

        return result;
    }


    public List<Integer> partitionLabelsV1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int end = 0;
        int start = 0;

        while (i < n) {
            int currWindow = map.get(s.charAt(i));
            end = Math.max(currWindow, end);

            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }

            i++;
        }

        return result;
    }


}
