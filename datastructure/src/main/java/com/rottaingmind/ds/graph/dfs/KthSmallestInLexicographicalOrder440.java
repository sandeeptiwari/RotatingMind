package com.rottaingmind.ds.graph.dfs;

public class KthSmallestInLexicographicalOrder440 {

    public int findKthNumber(int n, int k) {
        long curr = 1;
        k -= 1; // Since we start from the first number (1), we need k-1 more numbers

        while (k > 0) {
            int count = countNum(curr, curr + 1, n);

            if (count <= k) {
                curr++;
                k -= 1;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return (int) curr;
    }

    private int countNum(long curr, long next, int n) {
        int countNum = 0;

        while (curr <= n) {
            countNum += (next - curr);

            curr *= 10;
            next *= 10;
            next = Math.min(next, n + 1);
        }

        return countNum;
    }

    public static void main(String[] args) {
        KthSmallestInLexicographicalOrder440 obj = new KthSmallestInLexicographicalOrder440();
        System.out.println(obj.findKthNumber(13, 2));
    }
}
