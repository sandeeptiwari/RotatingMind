package com.rottaingmind.ds.greedy;

/**
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * <p>
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 * <p>
 * Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
 * <p>
 * If it cannot be done, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * Example 2:
 * <p>
 * Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 */
public class MinimumDominoRotationsForEqualRow1007 {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        // First try with x = tops[0] and x = bottoms[0]
        int r1 = check(tops[0], tops, bottoms);
        int r2 = check(bottoms[0], tops, bottoms);

        // If both are invalid (-1), return -1
        if (r1 == -1 && r2 == -1) return -1;
            // Otherwise return the minimum valid rotations from either
        else if (r1 == -1) return r2;
        else if (r2 == -1) return r1;
        else return Math.min(r1, r2);
    }

    // Helper method to check if a value can be made uniform on top or bottom with rotations
    private int check(int x, int[] tops, int[] bottoms) {
        int topRotation = 0;
        int bottomRotation = 0;

        for (int i = 0; i < tops.length; i++) {
            // If the top value is not x but the bottom value is x, increment bottom rotation
            if (tops[i] != x && bottoms[i] == x) {
                bottomRotation++;
            }
            // If the bottom value is not x but the top value is x, increment top rotation
            else if (tops[i] == x && bottoms[i] != x) {
                topRotation++;
            }
            // If neither top nor bottom is x, it's not possible to make the dominoes uniform with x
            else if (tops[i] != x && bottoms[i] != x) {
                return -1;
            }
        }

        // Return the minimum rotations needed, as we want the least rotations
        return Math.min(topRotation, bottomRotation);
    }

    public int minDominoRotations1(int[] tops, int[] bottoms) {
        int result = Integer.MAX_VALUE;

        for (int val = 1; val <= 6; val++) {
            int swaps = find(val, tops, bottoms);
            if (swaps != -1) {
                result = Math.min(result, swaps);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int find(int val, int[] tops, int[] bottoms) {
        int n = tops.length;
        int topSwap = 0;
        int bottomsSwap = 0;

        for (int i = 0; i < n; i++) {

            if (tops[i] != val && bottoms[i] != val) {
                return -1;
            } else if (tops[i] != val) {
                topSwap++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (tops[i] != val && bottoms[i] != val) {
                return -1;
            } else if (bottoms[i] != val) {
                bottomsSwap++;
            }
        }

        return Math.min(topSwap, bottomsSwap);
    }


}
