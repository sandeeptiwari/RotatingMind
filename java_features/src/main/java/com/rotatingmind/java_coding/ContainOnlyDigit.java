package com.rotatingmind.java_coding;

public class ContainOnlyDigit {

    //"[0-9]+"
    public static boolean containsOnlyDigit(String str) {
        return !str.chars()
                .anyMatch(ch -> !Character.isDigit(ch));
    }
}
