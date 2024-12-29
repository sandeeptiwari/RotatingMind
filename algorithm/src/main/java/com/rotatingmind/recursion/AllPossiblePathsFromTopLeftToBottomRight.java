package com.rotatingmind.recursion;

import java.util.Arrays;

/**
 * The problem is to count all the possible paths from top left to bottom right of an MxN matrix with the constraints
 * that from each cell you can either move to right or down.
 *
 * Return answer modulo 109+7.
 */
public class AllPossiblePathsFromTopLeftToBottomRight {

    // Define modulo value
    public static final int MOD = 1_000_000_007;

    public int numberOfPaths(int M, int N) {
        // Create a memoization array to store the results of subproblems
        int[][] memo = new int[M][N];

        // Initialize memoization array with -1 (indicating subproblem not yet solved)
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }

        // Call the recursive function with memoization
        return numberOfPathsRecursive(0, 0, M, N, memo) % MOD;
    }

    private int numberOfPathsRecursive(int i, int j, int M, int N, int[][] memo) {
        // Base case: If reached bottom-right corner, return 1
        if (i == M - 1 || j == N - 1) {
            return 1;
        }

        // If the result for current cell is already calculated, return it from memoization array
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Calculate the number of paths recursively
        int rightPaths = numberOfPathsRecursive(i, j + 1, M, N, memo);
        int downPaths = numberOfPathsRecursive(i + 1, j, M, N, memo);

        // Store the result in memoization array
        memo[i][j] = (rightPaths + downPaths) % MOD;

        return memo[i][j];
    }

    public static void main(String[] args) {
        //int m = 10;
        //int n = 10000000;
        int m = 3;
        int n = 3;

        AllPossiblePathsFromTopLeftToBottomRight  obj = new AllPossiblePathsFromTopLeftToBottomRight();
        int noOfPaths = obj.numberOfPaths(m, n);
        System.out.println(noOfPaths); //
    }

}
