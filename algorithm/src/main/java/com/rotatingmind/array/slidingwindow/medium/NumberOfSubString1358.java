package com.rotatingmind.array.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubString1358 {

    public int numberOfSubstrings(String s) {
        return atlestOne(s, 3);
    }

    /**
     * You're right, it's the logic behind generating those substrings that can be tricky. Let's break it down:
     *
     * The Core Logic
     *
     * The key is that when map.size() == 3 (or char_counts in the Python code has all three characters), we've found a valid substring ending at the right pointer.
     *
     * "abc" as the Base:
     * In your example, when right reaches 2, the current substring is "abc". This is the shortest substring ending at right that contains 'a', 'b', and 'c'.
     * Extending to the Right:
     * The crucial insight is that any substring that starts at left (which is 0 at that moment) and extends to any position from right to the end of the string will also contain 'a', 'b', and 'c'.
     * Therefore, we are not "imagining" those substrings, we are calculating how many substrings can be made by extending the current substring to the right.
     * Calculating the Count:
     * s.length() - right gives us the number of positions from right to the end of the string (inclusive).
     * In the case of "abcabc", when right = 2, s.length() = 6. 6 -2 = 4.
     * This means there are 4 different end positions from the current right position to the end of the string.
     *
     * "abc"abc
     *  ^^^
     * left right
     *
     * "abca"bc
     *  ^^^^
     * left   right
     *
     * "abcab"c
     *  ^^^^^
     * left   end
     *
     * "abcabc"
     *  ^^^^^^
     * left   end
     *
     * String: abcabc
     *         ^
     * left=0,right=2,count+=6-2=4 (abc,abca,abcab,abcabc)
     *          ^
     * left=1,right=3,count+=6-3=3 (bca,bcab,bcabc)
     *           ^
     * left=2,right=4,count+=6-4=2 (cab,cabc)
     *            ^
     * left=3,right=5,count+=6-5=1 (abc)
     *
     */
    public int atlestOne(String s, int k) {
        int n = s.length();
        int left = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            if ("abc".indexOf(currentChar) != -1) {
                map.put(s.charAt(right), map.getOrDefault(currentChar, 0) + 1);
            }

            while (map.size() == 3) {
                char currChar = s.charAt(left);
                count += s.length() - right;

                if (map.containsKey(currChar)) {
                    map.put(currChar, map.get(currChar) - 1);
                    if (map.get(currChar) == 0) {
                        map.remove(currChar);
                    }
                }
                left++;
            }

        }
        return count;
    }


    public static void main(String[] args) {
        NumberOfSubString1358 obj = new NumberOfSubString1358();
        System.out.println(obj.numberOfSubstrings("abcabc"));
    }

}
