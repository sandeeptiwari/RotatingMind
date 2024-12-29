package com.rotatingmind.recursion;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class  LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Integer, String> charsByKeyNum = new HashMap<>();
        charsByKeyNum.put(2, "abc");
        charsByKeyNum.put(3, "def");
        charsByKeyNum.put(4, "ghi");
        charsByKeyNum.put(5, "jkl");
        charsByKeyNum.put(6, "mno");
        charsByKeyNum.put(7, "pqrs");
        charsByKeyNum.put(8, "tuv");
        charsByKeyNum.put(9, "wxyz");
        List<String> combinations = new ArrayList<>();
        combinations(new StringBuilder(""), digits, combinations, charsByKeyNum, 0);
        return combinations;
    }

    public static void combinations(StringBuilder temp, String digits, List<String> combinations, Map<Integer, String> charsByKeyNum, int index) {

        if (digits.length() <= index) {
            combinations.add(temp.toString());
            return;
        }
        int key = digits.charAt(index) - '0';
        String value = charsByKeyNum.get(key);
        for (int i = 0; i < value.length(); i++) {
            temp.append(value.charAt(i));
            combinations(temp, digits, combinations, charsByKeyNum, index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        result.stream()
                .forEach(System.out::println);
    }
}
