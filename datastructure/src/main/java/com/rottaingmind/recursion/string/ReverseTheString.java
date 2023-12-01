package com.rottaingmind.recursion.string;

import com.rottaingmind.ds.stack.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseTheString {

    /**
     * input: s = "inside code"
     * @param str
     * @return
     */
    public static String reverseStr(String str) {
        Deque<String> stack = new ArrayDeque<String>();
        String[] words = str.split(" ");
        for (String word: words) {
            stack.push(word);
        }

        return stack.stream().
                map(ReverseTheString::reverse)
                .collect(Collectors.joining(" "));
    }

    private static String reverse(String str) {
        char[] chs = str.toCharArray();
        for (int i = 0, j = chs.length - 1; i < j; i++, j--) {
            char c = chs[i];
            chs[i] = chs[j];
            chs[j] = c;
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("inside code"));
    }
}
