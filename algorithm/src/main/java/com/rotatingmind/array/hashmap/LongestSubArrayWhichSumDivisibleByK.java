package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

record FreqIndex(int freq, int index) {}

public class LongestSubArrayWhichSumDivisibleByK {

    public static int getLongestSubArray(int[] a, int k) {
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ps = 0;
        int rem = 0;
        int len = 0;

        for (int i = 0; i < n; i++) {
            ps += a[i];
            rem = ps % k;

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                var remIndex = map.get(rem);
                len = Math.max(len, i - remIndex);
            }
            map.put(rem,  i);
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 6, 1, 4, 5};
        int k = 3;
        System.out.println(getLongestSubArray(a, k));
    }
}
