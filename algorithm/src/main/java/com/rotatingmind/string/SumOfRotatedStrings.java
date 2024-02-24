package com.rotatingmind.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.lang.Integer;

public class SumOfRotatedStrings {

    public static Set<String> findAllCombination(String num) {
        Set<String> combinations = new HashSet<>();
        combinations("", num, combinations);
        return combinations;
    }

    private static void combinations(String prefix, String src, Set<String> combinations) {
        int l = src.length();
        if (src.isEmpty()) {
            combinations.add(prefix);
        } else {
            for (int i = 0; i < src.length(); i++) {
                combinations(prefix + src.charAt(i), src.substring(0, i) + src.substring(i+1, l), combinations);
            }
        }
    }

   /* public static void main(String[] args) {
        Set<String> allCombination = findAllCombination("123");
        int sum = allCombination.stream()
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);


        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }*/

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        if (num != null && num.length() == 3) {
            String s2 = num.charAt(1) + num.substring(2,3) + num.charAt(0);
            String s3 = num.charAt(2) + num.substring(0,1) + num.charAt(1);

            int sum = Integer.parseInt(num) + Integer.parseInt(s2) + Integer.parseInt(s3);

            System.out.println(sum);
        }

    }
}
