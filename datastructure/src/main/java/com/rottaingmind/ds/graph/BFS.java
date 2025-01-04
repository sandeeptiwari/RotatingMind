package com.rottaingmind.ds.graph;

import java.util.*;

public class BFS {



    public static void main(String[] args) {
        int n = 10; // Number of nodes
        int[] visited = new int[n + 1];
        Queue<Integer> result = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            bfs(n, i, visited, result);
        }
    }


    /**
     *
     * @param n
     * @param source
     * @param visited
     * @param result
     *
     * TC = iterating 1-> n = o(n), we are visiting all visiting only once and inside there is another for loop then TC = o(n2) iff all node connected to each other
     *    = o(V + edges)
     *
     * SC = o(v) = both q and visited take v space which is no. of vertex
     */
    public static void bfs(int n, int source, int[] visited, Queue<Integer> result) {

        if(visited[source] == 1) {
            return;
        }

        // Create the graph as an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Example edges (populate the graph)
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(3).add(5);

        // Visited array
        // BFS queue
        result.add(source);
        visited[source] = 1;

        while (!result.isEmpty()) {
            int u = result.poll();
            System.out.println(u); // Process the node

            // Visit all neighbors
            // it will run degree of that node = 2 * edges
            for (int v : graph.get(u)) {
                if (visited[v] == 0) {
                    visited[v] = 1;
                    result.add(v);
                }
            }
        }
    }
}
