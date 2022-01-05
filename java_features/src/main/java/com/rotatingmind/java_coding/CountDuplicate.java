package com.rotatingmind.java_coding;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicate {

    public Map<Character, Integer> countDuplicateCharactersV1(String str) {

        Map<Character, Integer> result = new HashMap<>();
        for (char ch: str.toCharArray()) {
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public Map<Character, Long> countDuplicateCharacters(String str) {
        return str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void printDuplicateCharacters(String str) {
        for (int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if (Character.charCount(cp) == 2) {
                i++;
                System.out.println("ch -> "+ ch);
            }
        }
    }

    public static void main(String[] args) {
        printDuplicateCharacters("Sandeep Kumaar Tiwaarri");
    }
}
