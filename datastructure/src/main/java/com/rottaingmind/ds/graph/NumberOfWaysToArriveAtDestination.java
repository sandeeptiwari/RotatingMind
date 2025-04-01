package com.rottaingmind.ds.graph;


import java.util.*;

record TimePair(int source, int destination, int time) {}
public class NumberOfWaysToArriveAtDestination {

    /**
     * Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
     * Output: 4
     * Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
     * The four ways to get there in 7 minutes are:
     * - 0 ➝ 6
     * - 0 ➝ 4 ➝ 6
     * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
     * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
     */
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        // Step 1: Build adjacency list
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] road : roads) {
            adjMap.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            adjMap.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        // Step 2: Dijkstra's Setup
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        // Min-heap for Dijkstra's Algorithm (distance, node)
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0}); // Starting node

        // Step 3: Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long curDist = current[0];
            int node = (int) current[1];

            if (curDist > dist[node]) continue;

            for (int[] neighbor : adjMap.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0];
                long time = neighbor[1];

                // Found a shorter path
                if (dist[node] + time < dist[nextNode]) {
                    dist[nextNode] = dist[node] + time;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{dist[nextNode], nextNode});
                }
                // Found an equally short path
                else if (dist[node] + time == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        // Step 4: Return number of ways to reach destination
        return ways[n - 1];
    }
}
