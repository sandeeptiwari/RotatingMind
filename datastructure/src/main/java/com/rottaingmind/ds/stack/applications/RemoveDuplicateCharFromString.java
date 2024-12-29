package com.rottaingmind.ds.stack.applications;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * given a String contain chars a to z, Remove duplicate letters such that:
 *  1. Every letter come exactly once
 *  2. The resultant string should be lexo graphically smallest.
 *  Solution: sort the string and remove duplicate
 *
 *  TC = o(n)
 */
public class RemoveDuplicateCharFromString {

    public static String removeDuplicateEle(String str) {
        Map<Character, Integer> freqByChar = new HashMap<>();
        int[] occTable = new int[26];
        Deque<Character> stack = new ArrayDeque<>();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            freqByChar.merge(str.charAt(i), 1, Integer::sum);
        }

        //stack.push(str.charAt(0));

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (occTable[ch -'a'] == 1) {
                freqByChar.put(ch, freqByChar.get(ch) - 1);
                continue;
            }

            while (!stack.isEmpty() && ch < stack.peek() && freqByChar.get(stack.peek()) > 1) {
                char poppedChar = stack.pop();
                occTable[poppedChar - 'a'] = 0;
                freqByChar.put(poppedChar, freqByChar.get(poppedChar) - 1);
            }

            occTable[ch - 'a'] = 1;
            stack.push(ch);
        }

        //cbacdcbc
        StringBuilder builder = new StringBuilder();
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }

        return res;
    }

    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
        }

        boolean[] seen = new boolean[26]; // keep track seen
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (seen[curr]) continue; // if seen continue as we need to pick one char only
            while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
                seen[st.pop()] = false; // pop out and mark unseen
            }
            st.push(curr); // add into stack
            seen[curr] = true; // mark seen
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append((char) (st.pop() + 'a'));
        return sb.reverse().toString();
    }



    public static void main(String[] args) {
        String str = "bcabc";
        String str1 = "cbacdcbc";
        String str2 = "bbcaac";
        System.out.println(removeDuplicateEle(str2)); //acdb
        //System.out.println(removeDuplicateLetters(str));
    }
}
