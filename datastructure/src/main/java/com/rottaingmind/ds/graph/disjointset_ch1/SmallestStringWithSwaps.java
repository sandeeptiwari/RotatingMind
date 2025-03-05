package com.rottaingmind.ds.graph.disjointset_ch1;

import java.util.*;

/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 *
 * Hint:
 *   1. Think of it as a graph problem.
 *   2. Consider the pairs as connected nodes in the graph, what can you do with a connected component of indices ?
 *   3. We can sort each connected component alone to get the lexicographically minimum string.
 *
 *
 * Key Observations:
 *
 *  1. Connected Components:
 *    If indices can be swapped, they form a group (connected component).
 *    All characters within a connected component can be rearranged among themselves.
 *
 * 2. Graph Representation:
 *   Treat each character index as a node.
 *   Each pair [a, b] is an edge, meaning they belong to the same component.
 *   Connected components of this graph represent sets of indices that can be freely swapped.
 *
 * Find Union Approach:
 *
 *   We can use the Disjoint Set Union (DSU) (also known as Union-Find) to find connected components efficiently.
 *   Once we find components, we sort the characters within each component and reassign them in lexicographical order.
 *
 * Example Walkthrough
 *  s = "dcab"
 *   pairs = [[0, 3], [1, 2]]
 *
 * Graph Representation:
 *
 * (0) -- (3)
 * (1) -- (2)
 *
 * Components: {0,3} and {1,2}.
 *
 * Sorting Components:
 *
 * Component {0,3}: ['d', 'b'] → sorted → ['b', 'd']
 * Component {1,2}: ['c', 'a'] → sorted → ['a', 'c']
 *
 * Final Lexicographically Smallest String:
 * "bacd"
 */
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);

        // Step 1: Build Union-Find
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        // Step 2: Group indices by their root parent
        Map<Integer, List<Integer>> componentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            componentMap.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Step 3: Sort the characters in each component
        char[] result = new char[n];
        for (List<Integer> indices : componentMap.values()) {
            List<Character> chars = new ArrayList<>();
            for (int index : indices) {
                chars.add(s.charAt(index));
            }
            Collections.sort(chars);
            Collections.sort(indices);

            // Step 4: Place sorted characters in their respective positions
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = chars.get(i);
            }
        }

        return new String(result);
    }


    private static class UnionFind {
        private final int[] root;
        private final int[] rank;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (root[x] != x) {
                return find(root[x]);
            }

            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {

                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }

            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> testCases = new ArrayList<>();

        SmallestStringWithSwaps obj = new SmallestStringWithSwaps();

        // Test Case 1
        testCases.add(List.of(0, 3));
        testCases.add(List.of(1, 2));
        System.out.println(obj.smallestStringWithSwaps("dcab", testCases)); // Expected output: "abcd"

        // Test Case 2
        testCases.clear();
        testCases.add(List.of(0, 1));
        System.out.println(obj.smallestStringWithSwaps("dcab", testCases)); // Expected output: "cdab"

        // Test Case 3
        testCases.clear();
        testCases.add(List.of(0, 3));
        testCases.add(List.of(1, 2));
        testCases.add(List.of(0, 2));
        System.out.println(obj.smallestStringWithSwaps("dcab", testCases)); // Expected output: "abcd"

        // Test Case 4
        testCases.clear();
        testCases.add(List.of(1, 4));
        testCases.add(List.of(0, 3));
        testCases.add(List.of(2, 4));
        System.out.println(obj.smallestStringWithSwaps("edcba", testCases)); // Expected output: "abcde"

        // Test Case 5
        testCases.clear();
        testCases.add(List.of(0, 5));
        testCases.add(List.of(1, 4));
        testCases.add(List.of(2, 3));
        System.out.println(obj.smallestStringWithSwaps("zyxwvutsrq", testCases)); // Expected output: "qrstuvwxyz"
    }
}
