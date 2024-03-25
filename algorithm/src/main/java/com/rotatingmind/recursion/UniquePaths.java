package com.rotatingmind.recursion;

//https://leetcode.com/problems/unique-paths/description/

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *
 * 1 unit right or 1 unit Bottom direction
 */
public class UniquePaths {
    public static int uniquePaths(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }

        return uniquePaths(i, j + 1, m, n) + uniquePaths(i + 1, j, m, n);
    }




    public static void main(String[] args) {
        int res = uniquePaths(0, 0, 3, 7);
        System.out.println(res);
    }


}
