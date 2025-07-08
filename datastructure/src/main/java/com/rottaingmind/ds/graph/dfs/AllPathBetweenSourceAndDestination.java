package com.rottaingmind.ds.graph.dfs;

import java.util.*;

public class AllPathBetweenSourceAndDestination {


    private static void dfs(Map<Character, List<Character>> adjList,
                            Deque<LinkedList<Character>> stack,
                            List<LinkedList<Character>> paths) {

        while (!stack.isEmpty()) {
            LinkedList<Character> path = stack.pop();

            List<Character> neighbors = adjList.get(path.getLast());

            for (Character v : neighbors) {
                if (!path.contains(v)) { // to avoid revisiting same node in this path
                    LinkedList<Character> p = new LinkedList<>();
                    p.addAll(path);
                    p.addLast(v);
                    if (v == 'B') {
                        paths.add(p);
                    } else {
                        stack.push(p);
                    }
                }
            }
        }
    }


    private static Map<Character, List<Character>> buildAdjancyList(Character[][] edges) {

        Set<Character> vertices = new HashSet<>();
        for (Character[] edge : edges) {
            vertices.add(edge[0]);
            vertices.add(edge[1]);
        }

        Map<Character, List<Character>> adjList = new HashMap<>();

        for (Character v : vertices) {
            adjList.put(v, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            Character u = edges[i][0];
            Character v = edges[i][1];

            if (!adjList.get(u).contains(v)) adjList.get(u).add(v);
            if (!adjList.get(v).contains(u)) adjList.get(v).add(u);
        }

        return adjList;
    }

    public static void main(String[] args) {
        Character[][] edges = {
                {'A', 'B'},
                {'A', 'D'},
                {'A', 'C'},
                {'B', 'F'},
                {'B', 'E'},
                {'D', 'E'},
                {'C', 'E'},
                {'E', 'F'}
        };
        Map<Character, List<Character>> adjList = buildAdjancyList(edges);
        Deque<LinkedList<Character>> stack = new ArrayDeque<>();
        LinkedList<Character> l = new LinkedList<>();
        l.add(edges[0][0]);
        stack.push(l);

        List<LinkedList<Character>> paths = new ArrayList<>();

        dfs(adjList, stack, paths);

        for (LinkedList<Character> path : paths) {
            System.out.println(path);
        }

    }
}
