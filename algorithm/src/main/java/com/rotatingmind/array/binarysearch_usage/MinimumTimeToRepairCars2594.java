package com.rotatingmind.array.binarysearch_usage;

import java.util.Arrays;

/**
 * You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic.
 * A mechanic with a rank r can repair n cars in r * n2 minutes.
 *
 * You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
 *
 * Return the minimum time taken to repair all the cars.
 *
 * Note: All the mechanics can repair the cars simultaneously.
 *
 * Example 1:
 *
 * Input: ranks = [4,2,3,1], cars = 10
 * Output: 16
 *
 * Explanation:
 * - The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
 * - The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
 * - The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
 * - The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
 *
 * It can be proved that the cars cannot be repaired in less than 16 minutes.
 *
 * timeTaken = rank * numberOfCar * numberOfCar
 * numberOfCar = underroot(timeTaken / rank)
 *
 * low = 1 (The minimum time could be 1 minute)
 * high = min(ranks)×(cars)^2   ->The maximum time could be if the best mechanic repairs all cars:
 */
public class MinimumTimeToRepairCars2594 {
    private boolean canRepair( long mid, int[] ranks, int cars) {
        long totalCars = 0; // Use long to avoid overflow

        for (int rank : ranks) {
            totalCars += Math.sqrt((double) mid / rank);
            if (totalCars >= cars) return true; // Early exit if condition met
        }

        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        long bestMechanics = Arrays.stream(ranks).min().getAsInt(); // Ensure 'bestMechanics' is long
        long low = 1;
        long high = bestMechanics * (long) cars * cars; // Correct upper bound calculation

        while (low < high) { // Correct condition for binary search
            long mid = low + (high - low) / 2;

            if (!canRepair(mid, ranks, cars)) {
                low = mid + 1;
            } else {
                if (!canRepair(mid-1, ranks, cars)) return mid; // Correct adjustment — `mid` itself could be the answer
                high = mid - 1;
            }
        }

        return low; // Correct final answer
    }


}
