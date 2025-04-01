package com.rottaingmind.ds.graph.disjointset_ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You're given:
 *
 * n houses in a village numbered from 1 to n.
 * wells[]: An array where wells[i] is the cost to build a well in the ith house.
 * pipes[][]: A 2D array where each entry [house1, house2, cost] represents the cost of laying a pipe between two houses.
 *
 * Goal:
 * Minimize the total cost to supply water to every house.
 *
 * 🔎 Key Observations
 * Each house can get water in two ways:
 * Build a well directly in that house.
 * Connect to another house with a pipe.
 *
 * 💡 Optimal Strategy
 * Think of this as a Minimum Spanning Tree (MST) problem:
 * Treat each house as a node.
 * Treat pipes as edges with given costs.
 * Introduce a virtual node (node 0) that connects to each house with an edge cost equal to its well cost.
 * This trick allows us to unify all possible connections in a graph-like structure.
 *
 * 🛠️ Step-by-Step Solution Using Kruskal's Algorithm
 *
 * Step 1: Graph Construction
 * Create a new virtual node (node 0).
 * For each house i, add an edge from node 0 to house i with the well cost.
 * Add all given pipe connections as edges.
 *
 * Example Input:
 *
 * n = 3
 * wells = [1, 2, 2]  // Well costs for each house
 * pipes = [
 *    [1, 2, 1],
 *    [2, 3, 1]
 * ]
 *
 * Graph Representation (with virtual node 0):
 *
 * Node 0 --> Node 1 (cost = 1)
 * Node 0 --> Node 2 (cost = 2)
 * Node 0 --> Node 3 (cost = 2)
 * Node 1 --> Node 2 (cost = 1)
 * Node 2 --> Node 3 (cost = 1)
 *
 * Step 2: Sort All Edges
 * Sort all edges based on their cost (ascending order).
 *
 * Edges (sorted by cost):
 * [(1, 2, 1), (2, 3, 1), (0, 1, 1), (0, 2, 2), (0, 3, 2)]
 *
 * Step 1: Graph Construction
 * We'll create a graph where:
 *
 * Each house is treated as a node.
 * Each pipe is an edge with its cost.
 * We'll introduce a virtual node 0 that connects to each house with the respective well cost.
 *
 * Graph Visualization
 *
 *        [House 1] ------ 1 ------ [House 2]
 *          |                          |
 *          1                          1
 *          |                          |
 *      [Virtual 0]              [House 3]
 *          |
 *          2
 *          |
 *        [House 2]
 *
 *Step 2: Convert Graph to Edge List
 * We'll list all the connections (including the virtual node edges):
 *
 * Edges:
 * (0, 1, 1)   --> Well at House 1
 * (0, 2, 2)   --> Well at House 2
 * (0, 3, 2)   --> Well at House 3
 * (1, 2, 1)   --> Pipe between House 1 and 2
 * (2, 3, 1)   --> Pipe between House 2 and 3
 *
 *Step 3: Sort Edges by Cost
 * Sorting the edges in ascending order ensures that Kruskal's algorithm picks the cheapest edges first.
 * Sorted Edges:
 * (0, 1, 1)
 * (1, 2, 1)
 * (2, 3, 1)
 * (0, 2, 2)
 * (0, 3, 2)
 *
 * Step 4: Union-Find Data Structure
 * We'll use the Union-Find data structure to track connected components.
 *
 * Initially, each house (and virtual node) is its own parent:
 *
 * Parent Array: [0, 1, 2, 3]
 *
 * Step 5: Kruskal’s Algorithm (Step by Step)
 * ✅ Step 1: Pick edge (0, 1, 1)
 *
 * Union(0, 1) → Connects Virtual Node 0 and House 1
 *
 * Parent Array: [0, 0, 2, 3]
 * Total Cost: 1
 *
 * ✅ Step 2: Pick edge (1, 2, 1)
 *
 * Union(1, 2) → Connects House 1 and House 2
 *
 * Parent Array: [0, 0, 0, 3]
 * Total Cost: 2
 *
 * ✅ Step 3: Pick edge (2, 3, 1)
 *
 * Union(2, 3) → Connects House 2 and House 3
 *
 * Parent Array: [0, 0, 0, 0]
 * Total Cost: 3
 *
 *  Step 4: Skip (0, 2, 2) → Already connected (Cycle detected)
 *
 * ✅ Step 5: Skip (0, 3, 2) → Already connected (Cycle detected)
 *
 * Step 6: Final Result
 * Total Cost = 3
 * Houses 1, 2, and 3 are all connected to the water supply with minimum cost.
 */

class FindUnionV3 {
    private final int[] root;
    private final int[] rank;

    FindUnionV3(int size) {
        this.root = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }

        return root[x];
    }


    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
            } else {
                root[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }
}


public class OptimizeWaterDistributionInAVillage {


    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        FindUnionV3 obj = new FindUnionV3(n + 1); // Include virtual node (0)
        int cost = 0;
        //1. prepare edges, assume 0 is virtual node where well at same house
        List<int[]> edges = new ArrayList<>();

        // Add virtual node edges (Node 0 to each house)
        for (int i = 0; i < wells.length; i++) {
            edges.add(new int[]{0, i + 1, wells[i]});
        }

        //add pipes in edge
        edges.addAll(Arrays.asList(pipes));

        // sort the edges by cost
        edges = edges.stream().sorted(Comparator.comparingInt(a -> a[2])).toList();

        for(int[] edge: edges) {
            if (obj.find(edge[0]) != obj.find(edge[1])) {
                obj.union(edge[0], edge[1]);
                cost += edge[2];
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        OptimizeWaterDistributionInAVillage solution = new OptimizeWaterDistributionInAVillage();
        int n = 3;
        int[] wells = {1, 2, 2};
        int[][] pipes = {{1, 2, 1}, {2, 3, 1}};

        int result = solution.minCostToSupplyWater(n, wells, pipes);
        System.out.println("Minimum Cost to Supply Water: " + result);  // Output: 3
    }
}
