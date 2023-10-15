package com.rotatingmind.java8.stream.groupby;

import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByExamples {

    public static void example1() {
        List<String> characters = List.of("horiao", "laertes", "hemler");
        TreeMap<String, Long> lenByName = characters.stream()
                .collect(Collectors.groupingBy(Function.identity(), // function -> classifier
                        TreeMap::new, // supplier
                        Collectors.summingLong(String::length) //Collector -> downstream collector
                ));
        System.out.println(lenByName);
    }

    public static void main(String[] args) {
        example1();
    }
}
