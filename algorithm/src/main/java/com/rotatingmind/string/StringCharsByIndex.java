package com.rotatingmind.string;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCharsByIndex {

    public Map<Character, List<Integer>> groupByIndex(String input) {
       return IntStream.range(0, input.length())
               .boxed()
               .collect(Collectors.groupingBy(input::charAt));
    }

    public static void main(String[] args) {
        StringCharsByIndex obj = new StringCharsByIndex();
        Map<Character, List<Integer>> charsByIndex = obj.groupByIndex("standard");
        System.out.println(charsByIndex);
    }
}
