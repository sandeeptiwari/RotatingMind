package com.rotatingmind.array;

import java.util.Arrays;

/**
 * Given an unsorted array arr[] of N integers that are in Arithmetic Progression, the task is to print the missing element from the given series.
 *
 * Input: arr[] = {12, 3, 6, 15, 18}
 * Output: 9
 * Explanation:
 * The elements given in order are: 3, 6, 12, 15, 18.
 * Hence missing element is 9.
 *
 * Input: arr[] = {2, 8, 6, 10}
 * Output: 4
 * Explanation:
 * The elements given in order are: 2, 6, 8, 10.
 * Hence missing element is 4.
 */
public class FindTheMissingNumberInAp {

    private static int findMissing(int[] a, int left,
                                   int right, int d) {
        int n = a.length;

        int mid = (left + right) / 2;

        if (a[mid + 1] - a[mid] != d) {
            return a[mid] + d;
        }

        if (mid > 0 && a[mid] - a[mid - 1] != d) {
            return a[mid - 1] + d;
        }

        int term = a[0] + ((n/2) -1) * d;

        if (mid > 0 && a[mid] == term) {
            return findMissing(a, mid + 1, right, d);
        }

        return findMissing(a, left, mid - 1, d);
    }

    private static int findMissingV1(int[] a) {
        int n = a.length;

        int minEle = Arrays.stream(a).min().getAsInt();
        int maxEle = Arrays.stream(a).min().getAsInt();

        int d = (maxEle - minEle) / n;

        int x = 0;

        for (int i = 0; i < n; i++) {
            x = x ^ a[i];
        }

        for (int i = 0; i <= n; i++) {
            x = x ^ (minEle + (i * d));
        }

        return x;
    }



    /*public static void main(String[] args) {
        //int[] arr = {12, 3, 6, 15, 18};
        int[] arr = {2, 8, 6, 10};
        Arrays.sort(arr);
        int n = arr.length;

        int d = (arr[n-1] - arr[0]) / n;

        int num = findMissing(arr, 0, n, d);
        System.out.println("Missed Num " + num);
    }
*/
    public static void main(String[] args) {
        //int[] arr = {12, 3, 6, 15, 18};
        int[] arr = {2, 8, 6, 10};
        int num = findMissingV1(arr);
        System.out.println("Missed Num " + num);
    }
}
