package com.rotatingmind.array;

import java.util.Arrays;

/**
 * Here, to find out the maximum area of a hole, we need a maximum number of consecutive horizontal bars ‘maxHorizontal’ and a maximum consecutive number of vertical bars ‘maxVertical’ that are removed. Once, we can find them, as we know that ‘x’ number of horizontal bars can make ‘x’ + 1 hole free, so using this concept, our maximum hole area will be ('maxHorizonal' + 1) * ('maxVertical' + 1).
 *
 *
 * Algorithm:
 *
 * Declare two boolean arrays ‘boolH’ and ‘boolV’ of size ‘N’ + 1 and ‘M’ + 1 respectively and initialize them as true.
 * Run a loop ‘i’ = 0 to ‘X’
 * Set all those indexes false which are present in array ‘H’.
 * Run a loop ‘i’ = 0 to ‘Y’
 * Set all those indexes false which are present in array ‘V’.
 * Declare two variables as ‘localMaxHorizontal’ and ‘globalMaxHorizontal’ and set them as ‘0’ and minimum ‘-1’.
 * Run a loop ‘i’ = 1 to ‘N’
 * If ‘boolH’ is true denoting there exist a bar at this index
 * Set ‘localMaxHorizontal’ as 0
 *
 * Otherwise
 *
 * Increase ‘localMaxHorizontal’ by 1
 * Update ‘globalMaxHorizontal’ with the maximum of ‘globalMaxHorizontal’ and ‘localMaxHorizontal’
 * Declare two variables as ‘localMaxVertical’ and ‘globalMaxVertical’ and set them as ‘0’ and minimum ‘-1’.
 * Run a loop ‘i’ = 1 to ‘M’
 * If ‘boolV’ is true denoting there exist a bar at this index
 * Set ‘localMaxVertical’ as 0
 *
 * Otherwise
 *
 * Increase ‘localMaxVertical’ by 1
 * Update ‘globalMaxVertical’ with the maximum of ‘globalMaxVertical’ and ‘localMaxVertical’
 * Return (‘globalMaxHorizontal’ + 1) * (‘globalMaxVertical’ + 1)
 * Time Complexity
 * O(max( N, M)) where N and M are the numbers of horizontal and vertical bars respectively.
 *
 * Here, we use two single loops to find the maximum consecutive horizontal and vertical bars that can be removed. Hence, our time complexity is O(max( N, M)).
 *
 * Space Complexity
 * O(max( N, M)) where N and M are the numbers of horizontal and vertical bars respectively.
 *
 * Here, we use two single arrays to find the maximum consecutive horizontal and vertical bars that can be removed. Hence, our space complexity is O(max( N, M)).
 */
public class PrisonToBreak {

    public static int breakThePrison(int[] H, int[] V, int n, int m, int x, int y) {
        boolean[] xBools = new boolean[n + 1];
        Arrays.fill(xBools, true);

        for(int i: H) {
            xBools[i] = false;
        }

        boolean[] yBools = new boolean[m + 1];
        Arrays.fill(yBools, true);

        for(int j: V) {
            yBools[j] = false;
        }

        int cx =0, xMax = Integer.MIN_VALUE, cy = 0, yMax = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (xBools[i]) {
                cx = 0;
            } else {
                cx++;
                xMax = Math.max(cx, xMax);
            }
        }

        for (int i = 1; i <= m; i++) {
            if (yBools[i]) {
                cy = 0;
            } else {
                cy++;
                yMax = Math.max(cy, yMax);
            }
        }

        return (xMax + 1) * (yMax + 1);
    }

    public static void main(String[] args) {
        int[] H = {1, 3, 4};
        int[] V = {2, 3};
        int n = 4, m = 4;
        int x = 3, y = 2;

        int[] H1 = {2, 4};
        int[] V1 = {1, 4};
        int n1 = 6, m1 = 5;
        int x1 = 2, y1 = 2;

        int result = breakThePrison(H1, V1, n1, m1, x1, y1);
        System.out.println("result :: " + result);
    }
}
