package com.rottaingmind.ds.graph.disjointset_ch1;

public class NumOfConnectedCompInUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        FindUnion fu = new FindUnion(n);

        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            fu.union(x, y);
        }

        return fu.getCount();
    }

    class FindUnion {
        private final int[] root;
        private final int[] rank;
        private int count;

        public FindUnion(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;

            for(int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]); // Path compression
            }
            return root[x];
        }

        public void union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--; // Reduce component count when merging
            }

        }

        public int getCount() {
            return count;
        }
    }
}
