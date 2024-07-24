package com.rotatingmind.array;

import java.util.HashMap;
import java.util.Map;

public class MaxDiff {

    public static void main(String[] args) {
       int a[] = {3, 5, 2, 1, 7, 4};
       int n = a.length;

       int min = a[0];
       int diff = 0;
       int maxDiff = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            diff = a[i] - min;
            maxDiff = Math.max(maxDiff, diff);
            min = Math.min(a[i], min);
        }

        System.out.println("Max Diff " + maxDiff);


      // System.out.println("Max Diff " + getMaxDiffV2(a));
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


    private static int getMaxDiffV2(int[] arr) {
        int n = arr.length;
        int minEle = arr[0];
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (arr[i] - minEle > maxDiff) {
                maxDiff = (arr[i] - minEle);
            }

            if (arr[i] < minEle) {
                minEle = arr[i];
            }
        }
        return maxDiff;
    }


}
