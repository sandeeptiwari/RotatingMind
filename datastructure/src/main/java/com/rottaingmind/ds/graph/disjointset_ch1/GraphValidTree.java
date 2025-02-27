package com.rottaingmind.ds.graph.disjointset_ch1;


public class GraphValidTree {

   // [[0,1],[0,2],[0,3],[1,4]]
   //[[0,1],[1,2],[2,3],[1,3],[1,4]]
    private boolean isValidTree(int[][] edges) {
        int n = edges.length;
        int m = edges[0].length;

        UnionFindV1 uf = new UnionFindV1(m);
        for (int i = 0; i < n; i++) {
            if(!uf.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }

        return true;

    }

}

class UnionFindV1 {
    private final int[] root;
    private final int[] rank;
    private int count = 0;

    public UnionFindV1(int size) {
        rank = new int[size];
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {

        if (x == root[x]) {
            return x;
        }

        return root[x] = find(root[x]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootX] = rootY;
                rank[rootX]++;
            }
            count++;
        } else {
            // which means graph has cycle
            return false;
        }

        return true;
    }

    public int getCount() {
        return count;
    }
}
