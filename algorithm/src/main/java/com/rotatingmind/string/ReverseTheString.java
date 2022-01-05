package com.rotatingmind.string;


import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseTheString {
    private static final Pattern PATTERN =
            Pattern.compile(" +");

    public static String reverseWords(String str) {
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));

    }
    public static void main(String[] args) {
        System.out.println(reverseWords("Hello World"));
    }
}
