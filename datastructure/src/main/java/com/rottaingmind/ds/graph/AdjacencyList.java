package com.rottaingmind.ds.graph;

import java.util.*;

public class AdjacencyList {
    public static Map<Integer, List<Integer>> createAdjList(int[][] edges, int numVertices) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Initialize the adjacency list
        for (int i = 0; i < numVertices; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Add the edge in both directions (undirected graph)
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 3}
        };
        int numVertices = 4;

        Map<Integer, List<Integer>> adjList = createAdjList(edges, numVertices);

        // Print the adjacency list
        for (int vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }
}
