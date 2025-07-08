package com.rottaingmind.ds.greedy;

import java.util.*;

public class MinimumDeletionsToMakeStringKSpecial3085 {

    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        int n = word.length();
        int minDeletions = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            freq[word.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            int currDel = 0;
            int x = freq[i];

            for (int j = 0; j < 26; j++) {
                int y = freq[j];
                if (y < x) {
                    currDel += y;
                } else if ( Math.abs(y - x) > k) {
                    currDel += Math.abs(y - x - k);
                }
            }
            minDeletions = Math.min(minDeletions, currDel);
        }
        return minDeletions;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringKSpecial3085 obj = new MinimumDeletionsToMakeStringKSpecial3085();
        //System.out.println(obj.minimumDeletions("aabcaba", 0));
        System.out.println(obj.minimumDeletions("dabdcbdcdcd", 2));
        //System.out.println(obj.minimumDeletions("aaabaaa", 1));
    }
}
