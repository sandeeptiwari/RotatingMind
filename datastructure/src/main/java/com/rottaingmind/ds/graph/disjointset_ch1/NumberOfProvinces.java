package com.rottaingmind.ds.graph.disjointset_ch1;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * 1 ----- 2
 *     3
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */
public class NumberOfProvinces {
    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;

    public NumberOfProvinces(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
            // a standalone vertex with no connection to other vertices.
        }
    }

    private int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    private void union(int i, int j) {
        int rootX = find(root[i]);
        int rootY = find(root[j]);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        NumberOfProvinces dsu = new NumberOfProvinces(n);
        int numberOfComponents = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    numberOfComponents--;
                    dsu.union(i, j);
                }
            }
        }

        return numberOfComponents;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0}, {1,1,0}, {0,0,1}};
        NumberOfProvinces dsu = new NumberOfProvinces(isConnected.length);
        System.out.println(dsu.findCircleNum(isConnected));
    }
}
