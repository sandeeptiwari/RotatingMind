package com.rotatingmind.string;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose1657 {

    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n != m) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0; i < n; i++) {
            char ch1 = word1.charAt(i);
            int idx1 = ch1 - 'a';

            char ch2 = word2.charAt(i);
            int idx2 = ch2 - 'a';

            freq1[idx1]++;
            freq2[idx2]++;
        }

        //1.all char must available either non or both

        for(int i = 0; i < 26; i++) {

            if ( (freq1[i] != 0 && freq2[i] != 0) || (freq1[i] == 0 && freq2[i] == 0)) {
                continue;
            }

            return false;
        }

        // same frequency must be in both

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        DetermineIfTwoStringsAreClose1657 obj = new DetermineIfTwoStringsAreClose1657();
        System.out.println(obj.closeStrings("xxxxxxxxxxxxxxxxxxx", "zzzzzzzzzzzzzzzzzzz"));
    }
}
