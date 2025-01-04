package com.rottaingmind.ds.graph;

import com.rottaingmind.ds.linklist.List;

import java.util.Map;

/**
 * Find out count no of connected component in graph
 *
 * E.g.
 *
 *  1                              5
 * / \                           /  \
 *2---3                          6   7
 *     \                         \  /
 *      4                         8
 *
 * Here 1st and second are connected individually, so total 2 connected components
 */
public class NumberOfConnectedComponents {


    public int countComponents(Map<Integer, List<Integer>> graph, int nodes) {
        int components = 0;
        int[] marked = new int[graph.size()];
        for (int i = 0; i < nodes; i++) {
            if (marked[i] == 0) {
                components++;
                marked[i] = 1;
                // call from here dfs(i);
            }
        }
        return components;
    }

    public static void main(String[] args) {}
}
