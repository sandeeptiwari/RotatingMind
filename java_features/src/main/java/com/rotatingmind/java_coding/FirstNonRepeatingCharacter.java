package com.rotatingmind.java_coding;

public class FirstNonRepeatingCharacter {

    public Character getFirstNonRepeatingChar(String str) {
        int [] arr = new int[256];

        for (char ch: str.toCharArray()) {
                arr[ch] += 1;
        }

        for (int i = 0; i < str.length(); i++) {
            if(arr[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return Character.MAX_LOW_SURROGATE;
    }
}
