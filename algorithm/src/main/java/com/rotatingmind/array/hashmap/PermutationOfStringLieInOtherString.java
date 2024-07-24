package com.rotatingmind.array.hashmap;

import java.util.*;

/**
 * S1: "abkc"
 * s2: "pqbabkcd"
 *
 * Here s2 contains permutation of s1
 *
 * s = aababbaabbaaa
 * ar = ["ab", "ba", "ab"]  if ab + ba + ab = abbaab its in s
 *
 * String of array contains equals length, find starting indices of all substring in s that contains all the words from array in any order
 */
public class PermutationOfStringLieInOtherString {

    public static List<Integer> findIndices(String s, String[] strArr) {

        List<Integer> res = new ArrayList<>();

        if (s.isEmpty() || strArr.length == 0 || strArr.length * strArr[0].length() > s.length()) {
            return res;
        }
        int n = strArr.length;
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            wordFrequency.merge(strArr[i], 1, Integer::sum);
        }
        int len = strArr[0].length();
        int window = len * n;
        int srcLen = s.length();

        for (int i = 0; i <  srcLen - window; i++) {
            String currStr = s.substring(i, window + i);
            if (isContainsAllPerm(currStr, wordFrequency, len)) {
                res.add(i);
            }
        }

        return res;
    }

    public static boolean isContainsAllPerm(String str, Map<String, Integer> wordFrequency, int len) {

        Map<String, Integer> staticMap = new HashMap<>();

        for (int i = 0; i < str.length(); i = i + len) {
            String s = str.substring(i, i + len);
            staticMap.merge(s, 1, Integer::sum);
        }

        for (int i = 0; i < str.length(); i = i + len) {
            String s = str.substring(i, i + len);
            if (!Objects.equals(wordFrequency.get(s), staticMap.get(s))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aababbaabbaaa";
        String[] a = {"ab", "ba", "ab"};

        List<Integer> res = findIndices(s, a);
        res.forEach(System.out::println);
    }
}
