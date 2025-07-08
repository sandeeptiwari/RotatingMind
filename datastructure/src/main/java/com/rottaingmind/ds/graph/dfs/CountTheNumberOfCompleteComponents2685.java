package com.rottaingmind.ds.graph.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where
 * edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
 *
 * Return the number of complete connected components of the graph.
 *
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge
 * with a vertex outside of the subgraph.
 *
 * A connected component is said to be complete if there exists an edge between every pair of its vertices.
 *
 * Example 1:
 */
public class CountTheNumberOfCompleteComponents2685 {


    private int v;  // Track the number of nodes in the component
    private int e;  // Track the number of edges in the component

    private void dfs(int i, Map<Integer, Set<Integer>> adjList, boolean[] visited) {
        visited[i] = true;
        v++;  // Count nodes visited
        for (int ngbr : adjList.get(i)) {
            e++;  // Count each connection
            if (!visited[ngbr]) {
                dfs(ngbr, adjList, visited);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i]) { continue;}

            v = 0;
            e = 0;

            dfs(i, adjList, visited);

            if (v * (v-1) == e) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
