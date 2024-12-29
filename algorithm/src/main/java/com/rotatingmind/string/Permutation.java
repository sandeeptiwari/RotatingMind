package com.rotatingmind.string;

import java.util.*;

/**
 * s: abc
 * t: bca -> means t would be permutation of s if and only if t contains all chars which s contains
 * Number of choices for 1st char would be n, Now since we fixed 1 char so number of choices for next char
 * would be 2. and so on so forth
 * no of permutations = n * n-1 * n-2 ... = n!
 *
 * 1. So at level of zeroth recursion we only concern, what would be at zeroth position in string
 */
public class Permutation {

    public static void main(String[] args) {
        Set<String> permutations = new HashSet<>();
        permute("ABC").stream().forEach(System.out::println);
        System.out.println("============================================");
        allPermute("ABC", 0, permutations);
        permutations.stream().forEach(System.out::println);

        int[] a = {1, 2, 3};

        List<Integer> l = Arrays.stream(a)
                .boxed().toList();
        List<List<Integer>> prefix = new ArrayList<>();
    }


    /**
     * no of leaf node is n1 so TC = o(n!)
     */
    public static void allPermute(String s, int i, Set<String> permutations) {
        if (i == s.length()) {
            permutations.add(s);
        }
        for (int j = i; j <= s.length() - 1; j++) {
            s = swap(s, i, j);  // Right rotate
            allPermute(s, i + 1, permutations);
            s = swap(s, i, j); // left rotate for lexicographic
        }
    }

    private static String swap(String s, int i, int j) {
        char chs[] = s.toCharArray();
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
        return new String(chs);
    }

    public static Set<String> permute(String str) {
        return permute("", str);
    }

    public static Set<String> permute(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();

        if(n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permute(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }
}
