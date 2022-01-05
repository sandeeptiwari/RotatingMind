package com.rotatingmind.string;

import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    public static String parseString(String str) {
        String result = str.chars().distinct()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> String.valueOf(entry.getKey()))
                .collect(Collectors.joining(""));
        return result.length() > 0 ? result : null;
    }

    public static String parseStringV1(String str) {
        Stack<Character> charStack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            charStack.push(str.charAt(i));
        }
        int len = charStack.size();
        for (int i = 0; i < len; i++) {
            if(charStack.isEmpty()) {
                break;
            }
            char ele = charStack.pop();
            if (!charStack.isEmpty() && ele == charStack.peek()) {
                while (!charStack.isEmpty() && ele == charStack.peek()) {
                    charStack.pop();
                }
            } else {
                if (!tempStack.isEmpty() && ele == tempStack.peek()) {
                    tempStack.pop();
                } else {
                    tempStack.push(ele);
                }
            }
        }
        return tempStack.size() > 0 ? tempStack.stream().map(String::valueOf)
                .collect(Collectors.joining("")) : null;
    }

    public static String removeDuplicates(int index, String s) {
        System.out.println("index: " + index + ", string: " + s);
        if(s == null || s.length() == 0) {
            return "Answer: " + s;
        }
        int endIndex = -1;
        char c = s.charAt(index);
        for (int j = index + 1; j < s.length(); j++) {
            if (c == s.charAt(j)) {
                endIndex = j;
            } else {
                break;
            }
        }

        if (index < endIndex) {
            String newString = s.substring(0, index) + s.substring(endIndex + 1);
            if(index == 0) {
                return removeDuplicates(index, newString);
            }
            return removeDuplicates(index - 1, newString);
        } else {
            if(index + 1 >= s.length() - 1) {
                return removeDuplicates(index, s);
            }
            return removeDuplicates(index + 1, s);
        }
    }

    public static void main(String[] args) {
       // System.out.println(parseStringV1("aagbbbsssg"));//acbbbaddc
        System.out.println(parseStringV1("abbbaxz"));

        //System.out.println(removeDuplicates(0, "abbbaxz"));
    }
}
