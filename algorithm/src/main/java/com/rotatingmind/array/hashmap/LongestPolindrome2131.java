package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestPolindrome2131 {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;

        for (String word : words) {
            if (map.containsKey(word)) {
                result += 4;
                map.put(word, map.get(word) - 1);
            } else {
                map.put(word, 1);
            }
        }

        // Check for a word with both characters same to use in the center
        // Check for a word with both characters same to use in the center
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (word.charAt(0) == word.charAt(1) && count > 0) {
                result += 2;
                break;
            }
        }

        return result;
    }

}
