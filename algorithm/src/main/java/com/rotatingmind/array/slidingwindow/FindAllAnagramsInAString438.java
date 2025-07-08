package com.rotatingmind.array.slidingwindow;

import java.util.*;

public class FindAllAnagramsInAString438 {

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int w = p.length();

        List<Integer> results = new ArrayList<>();

        if (n < w) return results;

        for(int i = w; i <= n; i++) {
            String source = s.substring(i - w, i);
            if(isAnagram(source, p)) {
                results.add(i - w);
            }
        }

        return results;
    }

    public boolean isAnagram(String source, String target) {
        int n = source.length();
        int m = target.length();
        if (n != m) return false;

        if (source.equals(target)) return true;

        Map<Character, Integer> frequency = new HashMap<>();

        for(int i = 0; i < n; i++) {
            frequency.compute(source.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        for(int i = 0; i < n; i++) {
            var freq = frequency.getOrDefault(target.charAt(i), 0);
            if (freq > 0) {
                int updatedFreq = freq - 1;
                frequency.put(target.charAt(i), updatedFreq);
                if (updatedFreq == 0) {
                    frequency.remove(target.charAt(i));
                }
            }
        }

        return frequency.isEmpty();
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString438 obj = new FindAllAnagramsInAString438();
        //String s = "abab", p = "ab";
        String s = "cbaebabacd", p = "abc";
        List<Integer> res = obj.findAnagrams(s, p);
        res.forEach(System.out::println);
    }

}
