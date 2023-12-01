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
        int minElement = arr[0];

        for (int i = 0; i < len; i++) {
            if (arr[i] - minElement > maxDiff) {
                maxDiff = arr[i] - minElement;
            }

            if (arr[i] < minElement) {
                minElement = arr[i];
            }
        }

        return maxDiff;
    }

    /**
     * In this method, instead of taking the difference of each element with every other element,
     * we take difference with the smallest element found so far. So we need to keep track of two things:
     * 1) The maximum difference found so far
     * 2) The minimum element visited so far.
     *
     *
     * Conclusion:
     * We are running single loop n - 1 times and doing O(1) operations at each iteration.
     * So time complexity = (n - 1) * O(1) = O(n).
     * Space complexity = O(1), as we are using constant number of extra variables.
     */
    private static int getMaxDiffV1(int arr[]) {
        int minElement = arr[0];
        int maxDiff = -1;
        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] - minElement) > maxDiff) {
                maxDiff = arr[i] - minElement;
            }

            if (arr[i] < minElement) {
                minElement = arr[i];
            }
        }

        return maxDiff;
    }


}
