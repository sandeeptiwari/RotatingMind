package com.rottaingmind.ds.graph.disjointset_ch1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 */

class                    UnionFindV3 {
    private final Map<String, String> parent;
    private final Map<String, Double> weight;

    public UnionFindV3() {
        parent = new HashMap<>();
        weight = new HashMap<>();
    }

    /**
     *
     * Why 1.0?
     *  when a new variable (node) is encountered for the first time, it is considered as its own root in the Union-Find structure.
     * This follows the convention that any node divided by itself is 1.
     * Mathematically:
     * x/x=1
     * Example:
     * "a / a" = 1.0
     * "b / b" = 1.0
     */
    // Find with Path Compression
    public String find(String node) {
        if (!parent.containsKey(node)) {
            parent.put(node, node);
            weight.put(node, 1.0);
        }
        if (!node.equals(parent.get(node))) {
            String originalParent = parent.get(node);
            String root = find(originalParent);
            weight.put(node, weight.get(node) * weight.get(originalParent)); // Update weight during path compression -weight[node] represents the ratio of node / parent[node].
            parent.put(node, root);
        }
        return parent.get(node);
    }

    // Union with Weight Update
    public void union(String A, String B, double value) {
        String rootA = find(A);
        String rootB = find(B);

        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
            weight.put(rootA, value * weight.get(B) / weight.get(A)); // Maintain the ratio
        }
    }

    // Query for division result
    public double query(String A, String B) {
        if (!parent.containsKey(A) || !parent.containsKey(B)) return -1.0;

        String rootA = find(A);
        String rootB = find(B);

        if (!rootA.equals(rootB)) return -1.0;

        return weight.get(A) / weight.get(B);
    }
}


/**
 * Explanation of the Code
 * Union-Find Class:
 *
 * find(node): Uses path compression to update weights and find the root.
 * union(A, B, value): Merges A and B while maintaining the weight relationship.
 * query(A, B): Returns the division result if A and B are connected, otherwise -1.0.
 * Algorithm Complexity
 *
 * Union-Find operations (Find, Union): O(α(N)) ≈ O(1) (inverse Ackermann function, almost constant)
 * Processing Queries: O(1) per query
 * Total Complexity: O(N + Q) (N = number of equations, Q = number of queries)
 *
 * equations = [["a", "b"], ["b", "c"]]
 * values = [2.0, 3.0]
 * queries = [["a", "c"], ["b", "a"], ["a", "e"]]
 *
 *
 * a → b → c
 * (2.0) (3.0)
 *
 * Union Operations
 *  a / b = 2.0 → union(a, b, 2.0)
 *  b / c = 3.0 → union(b, c, 3.0)
 *
 * Find the Roots & Weights
 *  find(a) → root = c, weight = 6.0
 *  find(b) → root = c, weight = 3.0
 *  find(c) → root = c, weight = 1.0
 *
 * Query Results
 *  "a / c" → 6.0
 *  "b / a" → 1 / 2.0 = 0.5
 *  "a / e" → -1.0 (not found)
 *
 *
 * Final Thoughts
 * Graph Thinking: Treat variables as nodes, division as edges.
 * Union-Find Efficiency: Helps answer connectivity-based queries in almost constant time.
 * Weighted Path Compression: Ensures minimal updates and correct weight maintenance.
 */

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFindV3 uf = new UnionFindV3();

        // Step 1: Build the Union-Find structure
        for (int i = 0; i < equations.size(); i++) {
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        // Step 2: Process Queries
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = uf.query(queries.get(i).get(0), queries.get(i).get(1));
        }

        return result;
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"));

        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }
}
