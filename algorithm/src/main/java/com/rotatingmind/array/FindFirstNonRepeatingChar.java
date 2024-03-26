package com.rotatingmind.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingChar {

    public static void main(String[] args) {
        FindFirstNonRepeatingChar obj = new FindFirstNonRepeatingChar();
        System.out.println("First non repeating char " + obj.firstNonRepeatingCharV1("mumbai"));
    }

    public char firstNonRepeatingChar(String str) {
        Map<Character, Integer> charByCount = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charByCount.compute(ch, (k, v) ->  v == null ? 1 : ++v);
        }

        return charByCount.entrySet().stream()
                .filter(ele -> ele.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
    }

    public char firstNonRepeatingCharV1(String str) {
        int[] a = new int[256];
        int n = str.length();

        Arrays.fill(a, -1);

        for (int i = 0; i < n; i++) {
            int ch = str.charAt(i);
            if(a[ch] == -1) {
                a[ch] = i;
            } else {
                a[ch] = -2;
            }
        }

        int pos = Integer.MAX_VALUE;

        for (int i = 0; i < 256; i++) {
            if (a[i] >= 0) {
                pos = Math.min(pos, a[i]);
            }
        }

         return str.charAt(pos);
    }
}


