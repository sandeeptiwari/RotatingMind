package com.rotatingmind.array.hashmap;

import java.util.*;


public class NumberOfEquivalentDominoPairs1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int count = 0;
        Map<Pair, List<Integer>> indexByPair = new HashMap<>();


        for (int i = 0; i < n; i++) {
            var pair = new Pair(dominoes[i][0], dominoes[i][1]);
            indexByPair.computeIfAbsent(pair, k -> new ArrayList<>()).add(i);
        }


        for (int i = 0; i < n; i++) {
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            var pair1 = new Pair(a, b);
            var pair2 = new Pair(b, a);

            var indexes = indexByPair.getOrDefault(pair1, Collections.emptyList());
            if (indexes.isEmpty()) {
                indexes = indexByPair.getOrDefault(pair2, Collections.emptyList());
            }
            indexes.remove(Integer.valueOf(i));

            count += indexes.size();
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfEquivalentDominoPairs1128 obj = new NumberOfEquivalentDominoPairs1128();
        int [][] arr = {{1,1},{2,2},{1,1},{1,2},{1,2},{1,1}};
        System.out.println(obj.numEquivDominoPairs(arr));
    }

}
