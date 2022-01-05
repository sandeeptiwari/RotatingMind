package com.rotatingmind.string;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {
        permute("AB").stream().forEach(System.out::println);
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
