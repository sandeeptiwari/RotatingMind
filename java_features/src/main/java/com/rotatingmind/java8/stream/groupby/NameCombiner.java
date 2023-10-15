package com.rotatingmind.java8.stream.groupby;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Result(String name, String description) {
}

public class NameCombiner {

    public static List<Result> combine(List<Result> results) {
        Map<String, String> combinedResults = results.stream()
                .collect(Collectors.groupingBy(Result::name,
                        Collectors.mapping(Result::description, Collectors.joining(", "))
                ));

        return combinedResults.entrySet().stream()
                .map((packet) -> new Result(packet.getKey(), packet.getValue()))
                .toList();
    }

    public static void main(String[] args) {
        List<Result> results = Arrays.asList(
                new Result("A", "Google"),
                new Result("A", "Bard"),
                new Result("A", "Search"),
                new Result("A", "Meet"),
                new Result("B", "AI")
        );

        combine(results).forEach(System.out::println);
    }
}
