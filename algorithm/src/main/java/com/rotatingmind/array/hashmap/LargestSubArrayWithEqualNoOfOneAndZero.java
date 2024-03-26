package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithEqualNoOfOneAndZero {


    public static void largestSubArray(int[] a) {
        int n = a.length;
        int start = -1;
        int end = -1;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                a[i] = -1;
            }
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];

            if (map.containsKey(sum)) {
                int idx = map.get(sum);
                int len = i - idx;
                if (len > ans) {
                    start = idx + 1;
                    end = i;
                    ans = len;
                }
            } else {
                map.put(sum, i);
            }


        }
        System.out.println("Start " + start + " End " + end);

    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 0, 1, 1, 0, 0 };
        largestSubArray(a);
    }
}
