package com.rotatingmind.java_coding;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class CountVowelsAndConsonant {

    private static final Set<Character> allVowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

    public static Pair<Long, Long> countVowelsAndConsonant(String str) {

        str = str.toLowerCase();

        long vowels = str.chars()
                .filter(ch -> allVowels.contains((char) ch))
                .count();

        long consonants = str.chars()
                .filter(ch -> !allVowels.contains((char) ch))
                .count();

        return Pair.of(vowels, consonants);
    }

    public static Pair<Long, Long> countVowelsAndConsonantV1(String str) {

        str = str.toLowerCase();

        Map<Boolean, Long> result = str.chars()
                .mapToObj(ch -> ch)
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .collect(Collectors.partitioningBy(c -> allVowels.contains(c), Collectors.counting()));


        return Pair.of(result.get(true), result.get(false));
    }

    public static void main(String[] args) {
        String str = "BC";

        System.out.println(str.substring(2, 3));
    }
}
