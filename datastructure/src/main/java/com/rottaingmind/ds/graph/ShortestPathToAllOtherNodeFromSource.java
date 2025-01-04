package com.rottaingmind.ds.graph;

import java.util.*;

// Number of edges between 2 nodes
public class ShortestPathToAllOtherNodeFromSource {


    public static Map<Integer, Integer> bfsShortestPath(Map<Integer, List<Integer>> graph, int source) {
        // Step 1: Initialize structures
        Map<Integer, Integer> distance = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Set all distances to infinity (or max value)
        for (int node : graph.keySet()) {
            distance.put(node, Integer.MAX_VALUE);
        }

        // Step 2: Start BFS from the source
        queue.add(source);
        visited.add(source);
        distance.put(source, 0); // Distance to source is 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Visit all neighbors
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    distance.put(neighbor, distance.get(current) + 1); // Increment distance
                    queue.add(neighbor);
                }
            }
        }
        return distance;
    }

    /**
     * Time Complexity
     * Time Complexity:
     * 𝑂(𝑉 + 𝐸 )
     * O(V+E), where 𝑉 is the number of nodes and E is the number of edges.
     * Space Complexity:
     * 𝑂(𝑉)
     * O(V) for the visited set, distance map, and the queue.
     * @param args
     */
    public static void main(String[] args) {
        // Step 1: Represent the graph using an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4, 5));
        graph.put(3, Arrays.asList(1, 4, 8, 9));
        graph.put(4, Arrays.asList(2, 3, 5, 7));
        graph.put(5, Arrays.asList(2, 4, 6));
        graph.put(6, Arrays.asList(5));
        graph.put(7, Arrays.asList(4, 8));
        graph.put(8, Arrays.asList(7, 3, 9));
        graph.put(9, Arrays.asList(3, 8));

        int source = 1; // Starting node

        // Step 2: Call the BFS function to find the shortest paths
        Map<Integer, Integer> shortestPaths = bfsShortestPath(graph, source);

        // Step 3: Print the shortest paths
        System.out.println("Shortest path distances from node " + source + ":");
        for (Map.Entry<Integer, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("To node " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
