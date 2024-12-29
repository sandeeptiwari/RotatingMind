package com.rottaingmind.ds.stack.applications;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Petya recieved a gift of a string s with length up to 105 characters for his birthday. He took two more empty strings t and u and decided to play a game. This game has two possible moves:
 *
 * Extract the first character of s and append t with this character.
 * Extract the last character of t and append u with this character.
 * Petya wants to get strings s and t empty and string u lexicographically minimal.
 *
 * You should write a program that will help Petya win the game.
 *
 * Input
 * First line contains non-empty string s (1 ≤ |s| ≤ 105), consisting of lowercase English letters.
 *
 * Output
 * Print resulting string u.
 *
 * Examples
 * InputCopy
 * cab
 * OutputCopy
 * abc
 * InputCopy
 * acdb
 * OutputCopy
 * abdc
 */
public class MinimalString {

    public static void main(String[] args) {
        String s = "acdb";
        Deque<Character> st = new ArrayDeque<>();
        char[] suffix = new char[s.length()];
        int min = Integer.MAX_VALUE;
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            min = Math.min((int) s.charAt(i), min);
            suffix[i] = (char) min;
        }
        int i = 0;
        while (i < s.length()) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
                i++;
                continue;
            }
            while (!st.isEmpty() && st.peek() <= suffix[i]) {
                ans.append(st.pop());
            }
            st.push(s.charAt(i));
            i++;
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        System.out.println(ans);
    }
}
