package com.rottaingmind.ds.dp.practice;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/adjacents-are-not-allowed3528/1
public class MaxNonAdjacentSum2Ch5 {

    static int maxSum(int N, int mat[][])
    {
        int dp[] = new int[N];

        Arrays.fill(dp, -1);

        return sum(0, N, mat, dp);
    }

    static int sum(int i, int N, int mat[][], int dp[]) {
        if (i >= N) return 0;

        if (dp[i] != -1) return dp[i];

        int chooseClm = Math.max(mat[0][i], mat[1][i]);

        dp[i] = Math.max(chooseClm + sum(i + 2, N, mat, dp), sum(i + 1, N, mat, dp));

        return dp[i];
    }
}
