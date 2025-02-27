package com.rotatingmind.array.hashmap;

import java.util.*;

record Query(int x, int y) {
}
public class DistinctColorsAmongTheBalls3160 {


    public static int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Map<Integer, Integer> colorByPos = new HashMap<>();
        Map<Integer, Integer> colorFrequency = new HashMap<>();
        int uniqueColors = 0;

        for(int i = 0; i < n; i++) {
            int pos = queries[i][0];
            int newColor = queries[i][1];
            if (colorByPos.containsKey(pos)) {
                int oldColor = colorByPos.get(pos);
                colorFrequency.put(oldColor, colorFrequency.get(oldColor) - 1);
                if (colorFrequency.get(oldColor) == 0) {
                    colorFrequency.remove(oldColor);
                    uniqueColors--;  // Old color no longer used
                }
            }

            // Add new color
            colorByPos.put(pos, newColor);
            colorFrequency.put(newColor, colorFrequency.getOrDefault(newColor, 0) + 1);

            if (colorFrequency.get(newColor) == 1) {
                uniqueColors++;  // New unique color
            }

            // Store result
            result[i] = uniqueColors;
        }
        return result;
    }

    public static void main(String[] args) {
        int limit = 4;
        int[][] queries = {{1,4},{2,5}, {1,3},{3,4}};
        int[][] queries1 = {{0,1},{1,2},{2,2},{3,4},{4,5}}; //[1,2,2,3,4]

        int[] res = queryResults(limit, queries1);

        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
