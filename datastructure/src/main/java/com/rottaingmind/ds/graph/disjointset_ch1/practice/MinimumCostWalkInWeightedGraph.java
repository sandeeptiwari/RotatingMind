package com.rottaingmind.ds.graph.disjointset_ch1.practice;

public class MinimumCostWalkInWeightedGraph {


    class UnionFind {

        private final int[] root;
        private final int[] rank;
        private final int[] weight;
        
        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            weight = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 0;
                weight[i] = -1;
            }
        }

        public int find(int x) {
            while (x != root[x]) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y, int w) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                weight[rootX] &= w;
                return;
            }

            if(rank[rootY] < rank[rootX]) {
                root[rootY] = rootX;
                weight[rootX] &= weight[rootY] & w;
            } else if(rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
                weight[rootX] &= weight[rootY] & w;
            } else {
                root[rootY] = rootX;
                rank[rootX] ++;
                weight[rootX] &= weight[rootY] & w;
            }
        }

        public int getMinCost(int u, int v) {
            if (find(u) == find(v)) {
                return weight[find(u)];
            }
            return  -1;
        }
    }
}

