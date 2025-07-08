package com.rotatingmind.recursion;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

    public Set<String> permute(String s) {
        Set<String> result = new HashSet<>();

        permutations(s.toCharArray(), 0, result);





        return result;
    }

    public void permutations(char[] chars, int i, Set<String> result) {
        int n = chars.length;

        if (i == n) {
            result.add(new String(chars));
            return;
        }

        for (int j = i; j < n; j++) {
            swap(i, j, chars);
            permutations(chars, i+1, result);
            swap(i, j, chars);//backtrack
        }
    }

    private void swap(int i, int j, char[] chs) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        StringPermutations obj = new StringPermutations();
        obj.permute("ABC");
    }
}
