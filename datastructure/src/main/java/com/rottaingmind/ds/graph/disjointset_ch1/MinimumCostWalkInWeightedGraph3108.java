package com.rottaingmind.ds.graph.disjointset_ch1;

import java.util.Arrays;

/**
 * There is an undirected weighted graph with n vertices labeled from 0 to n - 1.
 *
 * You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.
 *
 * A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it.
 * It's important to note that a walk may visit the same edge or vertex more than once.
 *
 * The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered
 * during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.
 *
 * You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk,
 * the answer is -1.
 *
 * Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.
 *
 * Example 1:
 *
 * Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]
 *
 * Output: [1,-1]
 */
public class MinimumCostWalkInWeightedGraph3108 {


    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            uf.union(u, v, w);
        }
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; ++i) {
            int u = query[i][0];
            int v = query[i][1];
            result[i] = (u == v) ? 0 : uf.getMinCost(u, v);
        }
        return result;
    }


    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                weight[i] = -1; // Initialize weights to all 1s (bitwise)
            }
        }

        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        public void union(int u, int v, int w) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                weight[rootU] &= w;
                return;
            }
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
                weight[rootV] &= weight[rootU] & w;
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
                weight[rootU] &= weight[rootV] & w;
            } else {
                parent[rootV] = rootU;
                weight[rootU] &= weight[rootV] & w;
                rank[rootU]++;
            }
        }

        public int getMinCost(int u, int v) {
            if (find(u) == find(v)) {
                return weight[find(u)];
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        MinimumCostWalkInWeightedGraph3108 solution = new MinimumCostWalkInWeightedGraph3108();
        int n = 5;
        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        int[][] queries = {{0, 3}, {3, 4}};
        int[] result = solution.minimumCost(n, edges, queries);
        System.out.println(Arrays.toString(result)); // Output: [1, -1]
    }
}
