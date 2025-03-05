package com.rottaingmind.ds.dp;

import java.util.Arrays;

/**
 * Q1: A town is building a watchtower. The watchtower is located at (0, 0). Each unit height of the watchtower has a cost H.
 * There are N houses located at (x, y) coordinates. Each house will pay cost C if it comes under the surveillance of the watchtower.
 * The horizontal distance covered by the watchtower is the same as it's height. Find out the max profit you can make.
 *
 * Input:
 *   N number of houses
 *   list of (x, y) coordinates
 *   H cost to build unit height
 *   C cost each house pays the watchtower
 *
 *In the beginning the watchtower was located at the origin. For the followup he said watchtower location will be provided.
 * The (x, y) coordinates can be floats as well as H and C.
 *
 * N = 3
 * Houses = [(2,3),(-1,2),(4,1)] #List
 * H = 5 #cost per unit height of tower
 * C = 10 #cost paid by each house
 *
 * Aim : To find the maxprofit which covers all the houses with h height .
 *
 * Profit = (number of covered houses∗C)−(cost of building the tower)
 *
 * The goal is to find the height h that maximizes the profit.
 *
 * Examples:
 *
 * N = 3 (number of houses)
 * H = 2 (cost per unit height)
 * C = 5 (cost paid per house)
 * Houses = [ (1, 1), (2, 2), (3, 3) ]
 *
 * Explanation:
 * Let’s check different heights:
 *
 * h = 1
 *
 * Surveillance area: -1 ≤ x ≤ 1, y ≤ 1
 * Covered houses: (1,1)
 * Total revenue: 1 * 5 = 5
 * Total cost: 1 * 2 = 2
 * Profit: 5 - 2 = 3
 *
 * h = 2
 * Surveillance area: -2 ≤ x ≤ 2, y ≤ 2
 * Covered houses: (1,1), (2,2)
 * Total revenue: 2 * 5 = 10
 * Total cost: 2 * 2 = 4
 * Profit: 10 - 4 = 6
 *
 * h = 3
 * Surveillance area: -3 ≤ x ≤ 3, y ≤ 3
 * Covered houses: (1,1), (2,2), (3,3)
 * Total revenue: 3 * 5 = 15
 * Total cost: 3 * 2 = 6
 * Profit: 15 - 6 = 9
 * Final Answer:
 * Maximum profit is 9 when h = 3.
 *
 * Algorithm to Solve This
 * Iterate over all possible heights h = 1 to maxY, where maxY is the highest y coordinate among houses.
 * For each h, count the number of houses that fall within the surveillance area.
 * Compute the profit: (covered houses * C) - (h * H).
 * Track the maximum profit and return it.
 *
 */
public class WatchTowerG {

    public static int maxProfit(int[][] houses, int H, int C) {
        int maxProfit = 0;

        // Find the highest y-coordinate (this is the max height we need to check)
        int maxY = 0;
        for (int[] house : houses) {
            maxY = Math.max(maxY, house[1]);
        }

        // Try different heights from 1 to maxY
        for (int h = 1; h <= maxY; h++) {
            int count = 0;

            // Count houses covered by the watchtower
            for (int[] house : houses) {
                int x = house[0], y = house[1];
                if (Math.abs(x) <= h && y <= h) {
                    count++;
                }
            }

            // Calculate profit
            int revenue = count * C;
            int cost = h * H;
            int profit = revenue - cost;

            // Update max profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static int getMaxProfit(int N, int H, int C, int[][] houses) {
        // Step 1: Calculate the required height for each house (max(|x|, y))
        int[] houseHeight = new int[N];
        for (int i = 0; i < N; i++) {
            int x = houses[i][0], y = houses[i][1];
            houseHeight[i] = Math.max(Math.abs(x), y);
        }

        // Step 2: Sort the required heights
        Arrays.sort(houseHeight);

        // Step 3: Iterate through heights and calculate profit
        int maxProfit = 0;
        for (int i = 0; i < N; i++) {
            int h = houseHeight[i];
            int profit = C * (i + 1) - h * H;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[][] houses = { {1, 1}, {2, 2}, {3, 3} };
        int H = 2, C = 5;

        System.out.println("Max Profit: " + maxProfit(houses, H, C)); // Output: 9
    }
}
