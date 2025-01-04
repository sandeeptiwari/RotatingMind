package com.rottaingmind.ds.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {


    /**
     * TC = O(N + E)
     * @param adjList
     * @param visited
     * @param node
     */
    public void dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int node) {

        if (adjList == null || adjList.isEmpty() && visited.contains(node)) {
            return;
        }

        visited.add(node);
        System.out.println(node);

        for (Integer neighbor : adjList.get(node)) {
            dfs(adjList, visited, neighbor);
        }

    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            //dfs call from here
        }
    }
}
