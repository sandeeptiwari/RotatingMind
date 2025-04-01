package com.rotatingmind.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.
 *
 * A uni-value grid is a grid where all the elements of it are equal.
 *
 * Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
 *
 * Input: grid = [[2,4],[6,8]], x = 2
 * Output: 4
 * Explanation: We can make every element equal to 4 by doing the following:
 * - Add x to 2 once.
 * - Subtract x from 6 once.
 * - Subtract x from 8 twice.
 * A total of 4 operations were used.
 */
public class MinimumOperationsToMakeAUniValueGrid {

    public int minOperations(int[][] grid, int x) {
        // Step 1: Flatten the 2D grid into a 1D array
        List<Integer> values = new ArrayList<>();
        for (int[] row : grid) {
            for (int cell : row) {
                values.add(cell);
            }
        }

        // Step 2: Check for valid transformation condition
        int remainder = values.get(0) % x;
        for (int val : values) {
            if (val % x != remainder) {
                return -1;  // Impossible to make the grid uniform
            }
        }

        // Step 3: Sort the array and find the median
        Collections.sort(values);
        int median = values.get(values.size() / 2);

        // Step 4: Calculate the total operations
        int totalOperations = 0;
        for (int val : values) {
            totalOperations += Math.abs(val - median) / x;
        }

        return totalOperations;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeAUniValueGrid solver = new MinimumOperationsToMakeAUniValueGrid();

        int[][] grid1 = {{2, 4}, {6, 8}};
        System.out.println(solver.minOperations(grid1, 2));  // Output: 4

        int[][] grid2 = {{1, 2}, {3, 4}};
        System.out.println(solver.minOperations(grid2, 2));  // Output: -1

        int[][] grid3 = {{3, 9, 15}, {12, 18, 21}};
        System.out.println(solver.minOperations(grid3, 3));  // Output: 6
    }

}
