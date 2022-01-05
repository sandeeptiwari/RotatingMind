package com.rottaingmind.ds.stack.applications;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"  ->
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */
public class StackApplication {

    public static void main(String[] args) {
        Deque<Character> s1 = new ArrayDeque<>();
        String str1 = "3[a]2[bc]";
        String str2 = "3[a2[c]]";
        String str3 = "2[abc]3[cd]ef";
        String str4 = "abc3[cd]xyz";

        for (int i = 0; i < str4.length() ; i++) {
            s1.push(str4.charAt(i));
        }
        int size = s1.size();
        StringBuilder builder = new StringBuilder();
        StringBuilder rsStr = new StringBuilder();
        Deque<String> result = new ArrayDeque<>();
        int isCompleteBrace = 0;
        for (int i = 0; i < size; i++) {
            char current = s1.pop();
            if (Character.isDigit(current)) {
                int currentFrequency = Character.getNumericValue(current);
                builder.reverse();
                for (int j = 0; j < currentFrequency; j++) {
                    rsStr.append(builder);
                }
                result.push(rsStr.toString());
                builder.setLength(0);
                rsStr.setLength(0);
            } else if (current == ']') {
                if (isCompleteBrace == 0 && builder.length() != 0) {
                    builder.reverse();
                    result.push(builder.toString());
                    builder.setLength(0);
                }
                isCompleteBrace += 1;
            } else if (current == '[') {
                isCompleteBrace -= 1;
            } else {
                builder.append(current);
            }
        }
        builder.reverse();
        result.push(builder.toString());

        System.out.println("Parsed String -> "
                + result.stream().collect(Collectors.joining()));

        //parse("3[a2[c]]");
    }

    /*private static String parse(String str) {
        Deque<Integer> frequencies = new ArrayDeque<>();
        int currentFrequency = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (Character.isDigit(current)) {
                frequencies.push(Character.getNumericValue(current));
            }
        }
    }*/
}
