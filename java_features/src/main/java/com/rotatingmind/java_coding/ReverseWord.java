package com.rotatingmind.java_coding;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseWord {
    public static final String WHITESPACE = " ";
    public static final Pattern PATTERN = Pattern.compile(" +");

    public static String reverseWords(String str) {
        StringBuilder reverseString = new StringBuilder();
        String [] words = str.split(WHITESPACE);

        for (String word: words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() - 1 ; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }
            reverseString.append(reverseWord).append(WHITESPACE);
        }

        return reverseString.reverse().toString();
    }

    public static String reverseWordsV1(String str) {
        String stringWithReverseWords = PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(", "));
        return new StringBuilder(stringWithReverseWords).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsV1("the sky is blue"));
    }
}
