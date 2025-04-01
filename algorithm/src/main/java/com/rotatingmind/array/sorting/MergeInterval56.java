package com.rotatingmind.array.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeInterval56 {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) ->
                a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        List<int[]> res = new ArrayList<>();
        int[] currentInterval =  intervals[0];
        res.add(currentInterval);

        for (int[] interval: intervals) {
            if (currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // Add non-overlapping interval
                currentInterval = interval;
                res.add(currentInterval);
            }
        }
      return res.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        MergeInterval56 obj = new MergeInterval56();
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals = {{1,4},{5,6}};
        //int[][] intervals = {{0,4},{1, 5}};
        int[][] intervals = {{1,4}, {0,2},{3, 5}};
        int[][] results = obj.merge(intervals);

        for (int i = 0; i < results.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < 2; j++) {
                System.out.print(results[i][j] + ",");
            }
            System.out.print(" } \n");
        }
    }
}
