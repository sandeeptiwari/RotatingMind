package com.rottaingmind.ds.graph.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

record DistNode(int dist, int node) {}
public class FindClosestNodeToGivenTwoNodes2359 {

    private void dfs(int[] edges, int[] dist, int start) {
        boolean[] visited = new boolean[edges.length];
        int d = 0;
        int node = start;

        while (node != -1 && !visited[node]) {
            dist[node] = d++;
            visited[node] = true;
            node = edges[node];
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dfs(edges, dist1, node1);
        dfs(edges, dist2, node2);

        int result = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] edges = {2,2,3,-1};
        int node1 = 0, node2 = 1;
        int[] edges1 = {1, 2, -1};
        //int node1 = 0, node2 = 2;

        FindClosestNodeToGivenTwoNodes2359 obj = new FindClosestNodeToGivenTwoNodes2359();
        System.out.println(obj.closestMeetingNode(edges, node1, node2));
    }
}
