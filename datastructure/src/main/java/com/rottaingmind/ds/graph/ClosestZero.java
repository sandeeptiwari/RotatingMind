package com.rottaingmind.ds.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * The "Closest Zero" problem involves finding the minimum distance from each cell in a matrix to the nearest cell
 * containing a 0. This can be efficiently solved using Breadth-First Search (BFS) because BFS explores all neighbors
 * layer by layer, making it suitable for finding the shortest path in an unweighted graph.
 *
 * Here’s how to implement it step by step:
 *
 * mxn binary matrix, every cell connected to 4 adjacent, for every 1 distance to closest 0?
 *
 *  0 0 0
 *  0 1 0
 *  1 1 1
 *
 *  output: replace 1 with distance
 *  0 0 0
 *  0 1 0
 *  1 2 1 --> 2 indicate need to 2 move minimum to reach 0
 *
 *  run the bfs from every zero and take min distance from each 1
 *
 *  O(x * (n x m) + (mn -x) * x) = o(n2 * m2)
 *
 *  this idea is very costly, we need to use simultaneous BFS
 */

record Cell(int row, int col) {}
public class ClosestZero {

    /**
     * Input: A matrix grid of size m x n where each cell contains either 0 or 1.
     * Output: A matrix dist of size m x n where dist[i][j] is the minimum distance to the nearest 0.
     *
     * Approach:
     *
     * Use a queue to perform BFS.
     * Initialize the dist matrix:
     * For cells with 0, set dist[i][j] = 0 and add them to the BFS queue.
     * For cells with 1, set dist[i][j] = Integer.MAX_VALUE (a placeholder for unvisited cells).
     * Perform BFS:
     * For each cell dequeued, check its neighbors (up, down, left, right).
     * If the neighbor’s current distance is greater than the current cell’s distance + 1, update it and add the neighbor to the queue.
     * Return the dist matrix.
     */

    private static final int[][] DIRECTIONS = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0} // Right, Down, Left, Up
    };

    /**
     * BFS with Multiple Sources: All cells with 0 are enqueued initially, making the process simultaneous for all sources.
     * Time Complexity:
     * 𝑂( 𝑚 × 𝑛)
     * O(m×n), as each cell is visited once.
     * Space Complexity:
     * 𝑂(𝑚 × 𝑛)
     * O(m×n), for the queue and distance matrix.
     * @param grid
     * @return
     */
    public static int[][] findClosestZero(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // distance matrix initialized to max value
        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Queue for BFS
        Queue<Cell> queue = new ArrayDeque<>();


        // Initialize queue and distance for cells with 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new Cell(i, j)); // Add all cells with 0 to the queue
                }
            }
        }

        // BFS to calculate minimum distance to the nearest zero

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            int row = current.row();
            int col = current.col();

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check bounds and update distances
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (dist[newRow][newCol] > dist[row][col] + 1) {
                        dist[newRow][newCol] = dist[row][col] + 1;
                        queue.offer(new Cell(newRow, newCol));
                    }
                }

            }
        }

        return dist;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };

        int[][] result = findClosestZero(grid);

        System.out.println("Minimum distances to nearest zero:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
