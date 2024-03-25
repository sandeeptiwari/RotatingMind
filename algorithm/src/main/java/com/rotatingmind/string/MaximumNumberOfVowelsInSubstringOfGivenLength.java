package com.rotatingmind.string;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        int n = 0;

        List<Character> vowels = new ArrayList<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};

        Map<String, Integer> stringByLen = new HashMap<>();

        while (n < testCases) {
            String[] str = br.readLine().split(" ");
            String s = str[0];
            int k = Integer.parseInt(str[1]);

            stringByLen.put(s, k);
            n++;
        }

        for (Map.Entry<String, Integer> entry : stringByLen.entrySet()) {
              String inputStr = entry.getKey();
              int w = entry.getValue();

            int maxVowelInWindow = 0;


            for(int i = 0; i < w; i++) {
                if (vowels.contains(inputStr.charAt(i))) {
                    maxVowelInWindow++;
                }
            }

            int max = maxVowelInWindow;

            for(int i = w ; i < inputStr.length(); i++) {

                if (vowels.contains(inputStr.charAt(i))) {
                    max++;
                }

                if (vowels.contains(inputStr.charAt(i - w))) {
                    max--;
                }

                maxVowelInWindow = Math.max(max, maxVowelInWindow);
            }

            System.out.println(maxVowelInWindow);
        }
    }
}
