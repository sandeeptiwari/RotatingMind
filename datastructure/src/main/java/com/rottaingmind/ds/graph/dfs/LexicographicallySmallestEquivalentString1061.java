package com.rottaingmind.ds.graph.dfs;

import java.util.*;

public class LexicographicallySmallestEquivalentString1061 {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        StringBuilder result = new StringBuilder();
        Map<Character, List<Character>> res = buildAdjacencyList(s1, s2);
        for (int i = 0; i < baseStr.length(); i++) {
            int[] visited = new int[26];
            char ch = baseStr.charAt(i);
            result.append(dfs(res, ch, visited));

        }
        return result.toString();
    }

    private Character dfs(Map<Character, List<Character>> adjacencyList, char baseChar, int[] visited) {
        visited[baseChar -'a'] = 1;
        char minChar = baseChar;

        var chars = adjacencyList.get(baseChar);

        for (char c : chars) {
            if (visited[c - 'a'] == 0) {
                minChar = (char)Math.min(minChar, dfs(adjacencyList, c, visited));
            }
        }

        return minChar;
    }

    private Map<Character, List<Character>> buildAdjacencyList(String s1, String s2) {
        Map<Character, List<Character>> adj = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        return adj;
    }

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString1061 object = new LexicographicallySmallestEquivalentString1061();
        //Input: s1 = "parker", s2 = "morris", baseStr = "parser"
        String res1 = object.smallestEquivalentString("parker", "morris", "parser");

        System.out.println("Result " + res1);

        Map<Character, List<Character>> res = object.buildAdjacencyList("parker", "morris");
        for (Map.Entry<Character, List<Character>> entry : res.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
