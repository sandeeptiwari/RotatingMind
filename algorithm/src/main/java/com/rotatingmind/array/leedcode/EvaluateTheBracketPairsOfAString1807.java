package com.rotatingmind.array.leedcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

record IndexPair(int i, int j){}

public class EvaluateTheBracketPairsOfAString1807 {

    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder keyBuffer = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean insideBracket = false;

        for(char c : s.toCharArray()) {

            if (c == '(') {
                insideBracket = true;
                keyBuffer.setLength(0);
            } else if (c == ')') {
                insideBracket = false;
                String key = keyBuffer.toString();
                result.append(map.getOrDefault(key, "?")); // Replace key with value
            } else {
                if (insideBracket) {
                    keyBuffer.append(c);
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }



    public static void main(String[] args) {
        EvaluateTheBracketPairsOfAString1807 sol = new EvaluateTheBracketPairsOfAString1807();
        List<List<String>> knowledge = List.of(
                List.of("name", "Alice"),
                List.of("age", "25")
        );

        System.out.println(sol.evaluate("(name) is (age) years old.", knowledge));
        // Output: "Alice is 25 years old."

        System.out.println(sol.evaluate("Hello (user), welcome!", List.of()));
        // Output: "Hello ?, welcome!"
    }


    private String findKey(int start, char[] chars) {
        StringBuilder key = new StringBuilder();
        start++; // Move past '('

        while (start < chars.length && chars[start] != ')') {
            key.append(chars[start]);
            start++;
        }
        return key.toString();
    }

    private String valueByKey(String key, List<List<String>> knowledge) {
        for (int i = 0; i < knowledge.size(); i++) {

            if (knowledge.get(i).get(0).equals(key)) {
                return knowledge.get(i).get(1);
            }

        }
        return "?";
    }

    private void updateTheValue(char[] chars, String value, Map<String, List<IndexPair>> indexByKey) {

        for (Map.Entry<String, List<IndexPair>> entry : indexByKey.entrySet()) {

            List<IndexPair> pairs = entry.getValue();

            for (IndexPair pair : pairs) {
                int k = 0;
                for (int i = pair.i() + 1; i < pair.j(); i++) {
                    chars[i] = value.charAt(k);
                }
                chars[pair.i()] = ' ';
                chars[pair.j()] = ' ';
            }
        }
    }

}
