package com.rottaingmind.ds.graph.dir_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueInADirectedGraph {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph and compute indegrees
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] colorCount = new int[n][26]; // frequency table for each node

        // Start with nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                colorCount[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int answer = 0;
        int processedNodes = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processedNodes++;
            for (int v : adj.get(u)) {
                for (int i = 0; i < 26; i++) {
                    int colorIndex = colors.charAt(v) - 'a';
                    int add = (i == colorIndex) ? 1 : 0;
                    colorCount[v][i] = Math.max(colorCount[v][i], colorCount[u][i] + add);
                }

                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }

            for (int i = 0; i < 26; i++) {
                answer = Math.max(answer, colorCount[u][i]);
            }
        }

        return processedNodes < n ? -1 : answer;
    }

}
