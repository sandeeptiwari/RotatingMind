package com.rotatingmind.array.slidingwindow.medium;

import java.util.*;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII3306 {



    public static long countVowelSubstrings1(String word, int k) {
        int n = word.length();
        long count = 0;

        for (int i = 0; i < n; i++) { // Start of substring
            for (int j = i; j < n; j++) { // End of substring
                String sub = word.substring(i, j + 1);
                if (isValid(sub, k)) {
                    count++;
                }
            }
        }
        return count;
    }

  /*  private boolean isValid(String sub, int k) {
        // Will be filled in later
        return false;
    }*/

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }



    private static boolean isValid(String sub, int k) {
        int conso = 0;
        boolean[] vowels = new boolean[5]; // Track presence of each vowel

        for (char c : sub.toCharArray()) {
            if (isVowel(c)) {
                if (c == 'a') vowels[0] = true;
                if (c == 'e') vowels[1] = true;
                if (c == 'i') vowels[2] = true;
                if (c == 'o') vowels[3] = true;
                if (c == 'u') vowels[4] = true;
            } else {
                conso++;
            }
        }

        // Check if all vowels are present
        boolean allVowels = true;
        for (boolean v : vowels) {
            if (!v) {
                allVowels = false;
                break;
            }
        }

        return allVowels && conso == k;
    }

    private static long atlestK(String word, int k) {
        int n = word.length();
        long count = 0;

        // Tracks vowel counts
        Map<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        // Sliding window pointers
        int left = 0;

        for (int right = 0; right < n; right++) {
            char currentChar = word.charAt(right);

            // ✅ Add character to window
            if (isVowel(currentChar)) {
                vowelCount.put(currentChar, vowelCount.getOrDefault(currentChar, 0) + 1);
            } else {
                consonantCount++;
            }

            // ✅ Ensure window meets conditions
            while (vowelCount.size() == 5 && consonantCount >= k) {
                char currChar = word.charAt(left);
                count += word.length() - right;

                if (isVowel(currChar)) {
                    vowelCount.put(currChar, vowelCount.getOrDefault(currChar, 0) - 1);
                    if (vowelCount.get(currChar) == 0) {
                        vowelCount.remove(currChar);
                    }
                } else {
                    consonantCount--;
                }
                left++;
            }
        }

        return count;
    }


    //aeioqq
    public static long countOfSubstrings(String word, int k) {
       return atlestK(word, k) - atlestK(word, k + 1);
    }


    /*private static boolean isVowel(char ch) {
        String vowels = "aeiouAEIOU";
        return vowels.indexOf(ch) >= 0;
    }*/


    public static long countVowelSubstrings(String word, int k) {
        int n = word.length();
        long count = 0;

        for (int i = 0; i < n; i++) {
            int conso = 0;
            boolean[] vowels = new boolean[5];

            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (isVowel(c)) {
                    if (c == 'a') vowels[0] = true;
                    if (c == 'e') vowels[1] = true;
                    if (c == 'i') vowels[2] = true;
                    if (c == 'o') vowels[3] = true;
                    if (c == 'u') vowels[4] = true;
                } else {
                    conso++;
                }

                boolean allVowels = true;
                for (boolean v : vowels) {
                    if (!v) {
                        allVowels = false;
                        break;
                    }
                }

                if (allVowels && conso == k) {
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println("Result :: " + countOfSubstrings("aeiou", 0));//1
        System.out.println("Result :: " + countOfSubstrings("ieaouqqieaouqq", 1));//3
        System.out.println("Result :: " + countOfSubstrings("iqeaouqi", 2));//3
    }
}
