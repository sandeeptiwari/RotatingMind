 package com.rottaingmind.ds.graph.disjointset_ch1;

public class DisJointSetUnionByRank {
    private int[] root;
    private int[] rank;

    public DisJointSetUnionByRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    /**
     * At time 0:52 we have effectively constructed a linked list of nodes with 5 as the root node, where 4 points to 5, 3 to 4, 2 to 3, 1 to 2, and 0 to 1.
     * This demonstrates the main inefficiency of Quick Union. A keen observer will notice that union(x, y) in our previous implementation of Quick Union,
     * will always point rootY to rootX. So the actual order of operations to produce the "tree" shown at 0:52 would be union(1, 0), union(2, 0), union(3, 0), union(4, 0), union(5, 0).
     * Nevertheless, the key idea remains the same: Quick Union runs the risk of forming a skewed tree.
     *
     * Note:
     * N is the number of vertices in the graph.
     *
     * For the union-find constructor, we need to create two arrays of size
     * N each.
     * For the find operation, in the worst-case scenario, when we repeatedly union components of equal rank, the tree height will be at most
     *
     * log(N)+1, so the find operation requires
     * O(logN) time.
     * For the union and connected operations, we also need
     * O(logN) time since these operations are dominated by the find operation.
     *
     * Space Complexity
     * We need
     * O(N) space to store the array of size N.
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
    public static void main(String[] args) throws Exception {
        DisJointSetUnionByRank uf = new DisJointSetUnionByRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }

}
