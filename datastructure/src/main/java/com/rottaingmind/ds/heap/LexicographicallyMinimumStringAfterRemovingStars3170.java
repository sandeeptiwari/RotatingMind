package com.rottaingmind.ds.heap;

import java.util.*;
record ChPair(Character ch, Integer index) {}
public class LexicographicallyMinimumStringAfterRemovingStars3170 {

    public String clearStars(String s) {

        if (s == null || !s.contains("*")) {
            return s;
        }
        int n = s.length();
        char[] chars = s.toCharArray();

        PriorityQueue<ChPair> minHeap = new PriorityQueue<>(
                Comparator.comparing(ChPair::ch)
                        .thenComparing(Comparator.comparing(ChPair::index).reversed())
        );

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '*') {
                minHeap.add(new ChPair(s.charAt(i), i));
            } else {
               var pair = minHeap.poll();
                assert pair != null;
                int index = pair.index();
                chars[index] = '*';
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (chars[i] != '*') {
                sb.append(chars[i]);
            }
        }

     return sb.toString();
    }

    public static void main(String[] args) {
        LexicographicallyMinimumStringAfterRemovingStars3170 obj = new LexicographicallyMinimumStringAfterRemovingStars3170();
        System.out.println(obj.clearStars("aaba*"));
    }
}
