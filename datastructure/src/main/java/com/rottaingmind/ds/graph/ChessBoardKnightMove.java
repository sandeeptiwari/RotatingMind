package com.rottaingmind.ds.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Knight : can move 2  steps one direction and 1 in perpendicular of that
 *
 * n X n matrix and given position of knight
 * source = (0, 0)
 * destination = (1, 0)
 *
 * need to find minimum move to reach the destination
 *
 * Ans.
 * (0,0) -> (2, 1) -> (0, 2) -> (1, 0)
 *
 * Case when move not possible : if source and destination at center then move is not possible
 *
 * what all corrdination K can move from any coord (i,j)
 *  (i +-2, j+-1)
 *  (i+-1, j+-2) = 8 moves
 *
 *  NOte: since we have already above formula, so no need to maintain adjacency list
 *
 *  node1(0, 0) --- (1, 2)
 *       |
 *       |
 *       |
 *      (2, 1)
 *
 *   Explanation:
 *
 *Step 1:
 * Understand the Knight’s Move
 *      A knight in chess moves in an "L" shape:
 *
 *      Two squares in one direction (horizontal or vertical), then one square perpendicular to it, or
 *      One square in one direction, then two squares perpendicular.
 *      From any given square, a knight can have up to 8 possible moves.
 *
 * For example: If the knight is at (3, 3) on an 8×8 board (row, column):
 *
 * Possible moves are: (1, 2), (1, 4), (2, 1), (2, 5), (4, 1), (4, 5), (5, 2), (5, 4).
 *
 * Step 2: Represent the Chessboard as a Graph
 *      Each square on the board is a node.
 *      A knight's valid move from one square to another represents an edge.
 *      For example, on a 3×3 board:
 *
 *      Node (1, 1) is connected to (2, 3) and (3, 2), and so on.
 *      This forms a graph where you try to traverse every node exactly once.
 */

// `steps` is the number of moves made so far
record Move(int row, int col, int steps) {}

public class ChessBoardKnightMove {


    /**
     * Problem:
     * Find the shortest path for a knight to go from (0, 0) to (4, 4) on a 5×5 board.
     *
     * Steps:
     * Start BFS at (0, 0):
     *
     * Enqueue: (0, 0, [path so far]) → [(0, 0, [(0, 0)])].
     * Mark (0, 0) as visited.
     *
     * Process (0, 0):
     *
     * Possible moves from (0, 0): [(2, 1), (1, 2)].
     * Enqueue: (2, 1, [(0, 0), (2, 1)]), (1, 2, [(0, 0), (1, 2)]).
     * Mark (2, 1) and (1, 2) as visited.
     **/

    /**
     * The KNIGHT_MOVES array is a predefined list of all possible moves a knight can make in chess. A knight moves in an "L" shape on the chessboard, meaning it moves:
     *
     * Two squares in one direction (horizontal or vertical) and one square in the perpendicular direction, OR
     * One square in one direction and two squares in the perpendicular direction.
     * This creates 8 possible moves for a knight at any given position (as long as the moves stay within the board boundaries).
     *
     * The knight's 8 possible moves can be visualized as relative coordinate changes from its current position. For example:
     *
     * 1. Move 2 rows up and 1 column left.
     *
     * 2. Move 2 rows up and 1 column right.
     *
     * 3. Move 2 rows down and 1 column left.
     *
     * 4. Move 2 rows down and 1 column right.
     *
     * 5. Move 1 row up and 2 columns left.
     *
     * 6. Move 1 row up and 2 columns right.
     *
     * 7. Move 1 row down and 2 columns left.
     *
     * 8. Move 1 row down and 2 columns right.
     *
     * These moves are represented as changes in (row, col) coordinates relative to the knight's current position.
     *
     * Visualization of Knight Moves
     * From any position (r, c), the knight can move to:
     *
     * Move Direction	 Row Change 	Column Change
     * 2 Up, 1 Left         -2              -1
     * 2 Up, 1 Right	    -2	            +1
     * 2 Down, 1 Left	    +2	            -1
     * 2 Down, 1 Right	    +2	            +1
     * 1 Up, 2 Left	        -1	            -2
     * 1 Up, 2 Right	    -1	            +2
     * 1 Down, 2 Left	    +1	            -2
     * 1 Down, 2 Right	    +1	            +2
     *
     */
    private static final int[][] KNIGHT_MOVES = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };

    // Chessboard dimensions (5x5 for this example)
    private static final int BOARD_SIZE = 5;



    public static int findShortestPath(int startRow, int startCol, int targetRow, int targetCol) {
        // Initialize a queue for BFS
        Queue<Move> queue = new ArrayDeque<>();
        // Track visited positions
        boolean[][] visited = new boolean[BOARD_SIZE][BOARD_SIZE];

        // Start BFS from the initial position
        queue.offer(new Move(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        // Perform BFS
        while (!queue.isEmpty()) {
            Move current = queue.poll();

            // If the target position is reached, return the number of steps
            if (current.row() == targetRow && current.col() == targetCol) {
                return current.steps();
            }

            // Explore all possible knight moves
            for (int[] move : KNIGHT_MOVES) {
                int newRow = current.row() + move[0];
                int newCol = current.col() + move[1];

                // Check if the new position is within bounds and not visited
                if (isValidMove(newRow, newCol, visited)) {
                    visited[newRow][newCol] = true; // Mark as visited
                    queue.offer(new Move(newRow, newCol, current.steps() + 1));
                }
            }
        }

        // If the target cannot be reached, return -1
        return -1;
    }


    /**
     * Checks if a position is valid (within bounds and not visited).
     *
     * @param row     Row index
     * @param col     Column index
     * @param visited 2D boolean array of visited positions
     * @return True if the position is valid, false otherwise
     */
    private static boolean isValidMove(int row, int col, boolean[][] visited) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && !visited[row][col];
    }

    public static void main(String[] args) {
        int startRow = 0, startCol = 0; // Starting position of the knight
        int targetRow = 4, targetCol = 4; // Target position

        int shortestPath = findShortestPath(startRow, startCol, targetRow, targetCol);

        if (shortestPath != -1) {
            System.out.println("The shortest path from (" + startRow + ", " + startCol +
                    ") to (" + targetRow + ", " + targetCol + ") is: " + shortestPath + " moves.");
        } else {
            System.out.println("The target position is unreachable.");
        }
    }


}
