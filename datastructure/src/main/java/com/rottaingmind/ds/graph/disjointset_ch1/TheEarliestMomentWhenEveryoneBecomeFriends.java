package com.rottaingmind.ds.graph.disjointset_ch1;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {

    /**
     * Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], n = 6
     * Output: 20190301
     * Explanation:
     * The first event occurs at timestamp = 20190101, and after 0 and 1 become friends, we have the following friendship groups [0,1], [2], [3], [4], [5].
     * The second event occurs at timestamp = 20190104, and after 3 and 4 become friends, we have the following friendship groups [0,1], [2], [3,4], [5].
     * The third event occurs at timestamp = 20190107, and after 2 and 3 become friends, we have the following friendship groups [0,1], [2,3,4], [5].
     * The fourth event occurs at timestamp = 20190211, and after 1 and 5 become friends, we have the following friendship groups [0,1,5], [2,3,4].
     * The fifth event occurs at timestamp = 20190224, and as 2 and 4 are already friends, nothing happens.
     * The sixth event occurs at timestamp = 20190301, and after 0 and 3 become friends, we all become friends.
     */
    public int earliestAcq(int[][] logs, int n) {

        logs = Arrays.stream(logs)
                .sorted(Comparator.comparingInt(a -> a[0]))
                .toArray(int[][]::new);

        FindUnionV1 obj = new FindUnionV1(n);
        int  earliest = n;
        for (int i = 0; i < logs.length; i++) {
            int timestamp = logs[i][0];
            int x = logs[i][1];
            int y = logs[i][2];
            if (obj.union(x, y)) {
                earliest--;
            }

            // If all nodes are connected, return the timestamp

            // If all nodes are connected, return the timestamp

            if (earliest == 1) {
                return timestamp;
            }
        }
        return -1;
    }

    class FindUnionV1 {

        private int[] root;
        private int[] rank;
        private int count;

        public FindUnionV1(int size) {
            root = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            count = size;
        }


        public int find(int x) {

            if (root[x] != x) {
                root[x] = find(root[x]);
            }

            return root[x];
        }


        public boolean union(int X, int Y) {
            int rootX = find(X);
            int rootY = find(Y);

            if (rootX != rootY) {

                if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else {
                    root[rootX] = rootY;
                    rank[rootX]++;
                }
                return true;
            } else {
                return false;
            }
            //count--;
        }

        public int getCount() {
            return count;
        }
    }


    public static void main(String[] args) {
        int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int n = 6;

        TheEarliestMomentWhenEveryoneBecomeFriends obj = new TheEarliestMomentWhenEveryoneBecomeFriends();
        System.out.println("Result " + obj.earliestAcq(logs, n));
    }
}
