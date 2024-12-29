package com.rotatingmind.array.sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomStringRankSorting {

    public static String customSortString(String orderStr, String sourceStr) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < orderStr.length(); i++) {
            map.put(orderStr.charAt(i), i);
        }

        return sourceStr.chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.comparingInt(s -> map.getOrDefault(s, 26)))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }


    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        System.out.println(customSortString(order, s));
    }
}
