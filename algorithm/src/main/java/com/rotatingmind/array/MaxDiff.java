package com.rotatingmind.array;

import java.util.HashMap;
import java.util.Map;

public class MaxDiff {

    public static void main(String[] args) {
       int arr[] = {3, 5, 2, 1, 7, 4};

       Map<Integer, Integer> map = new HashMap<>();
       System.out.println(map.get(1));

       System.out.println("Max Diff " + getMaxDiff(arr));
    }

    private static int getMaxDiff(int arr[]) {
        int maxDiff = arr[1] - arr[0];
        int len = arr.length;
        int marker = arr[0];

        for (int i = 0; i < len; i++) {

            if (arr[i] - marker > maxDiff) {
                maxDiff = arr[i] - marker;
            }

            if (arr[i] < marker) {
                marker = arr[i];
            }
        }

        return maxDiff;
    }


}
