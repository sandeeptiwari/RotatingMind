package com.rotatingmind.java_coding;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {

    private static final int EXTENDED_ASCII_CODES = 256;

    public char firstNonRepeatedCharacter(String str) {
        int[] flags = new int [EXTENDED_ASCII_CODES];

        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.toCharArray().length; i++) {
            char c = str.charAt(i);
            if (flags[c] == -1) {
                flags[c] = i;
            } else {
                flags[c] = -2;
            }
        }

        int pos = Arrays.stream(flags)
                .boxed()
                .filter(ele -> ele >= 0)
                .reduce((i1, i2) -> Math.min(i1, i2)).orElse(-1);
        return pos == -1 ? Character.MAX_LOW_SURROGATE : str.charAt(pos);
    }

    public char firstNonRepeatedCharacterV1(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return map.entrySet().stream().filter(ele -> ele.getValue() == 1).findFirst().get().getKey();
    }

    public String firstNonRepeatedCharacterV2(String str) {
        LinkedHashMap<Integer, Long> map = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        int cp = map.entrySet().stream()
                .filter(ele -> ele.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar obj = new FirstNonRepeatingChar();
        System.out.println("First char => " + obj.firstNonRepeatedCharacterV2("kkaavvyaTiwari"));
    }
}
