package com.rotatingmind.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingChar {

    public static void main(String[] args) {
        FindFirstNonRepeatingChar obj = new FindFirstNonRepeatingChar();
        System.out.println("First non repeating char " + obj.firstNonRepeatingChar("mumbai"));
    }

    public char firstNonRepeatingChar(String str) {
        Map<Character, Integer> charByCount = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            charByCount.compute(ch, (k, v) ->  v == null ? 1 : ++v);
        }

        return charByCount.entrySet().stream()
                .filter(ele -> ele.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
    }
}


