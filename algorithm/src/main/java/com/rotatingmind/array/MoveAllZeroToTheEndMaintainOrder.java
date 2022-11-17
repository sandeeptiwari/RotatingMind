package com.rotatingmind.array;

import java.util.Arrays;

public class  MoveAllZeroToTheEndMaintainOrder {

    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 8, 7, 5, 0, 10, 0, 0, 20, 0};
        int arr1[] = {0, 1, 0, 0, 0, 10};
       // moveZero1(arr);
        int arr2[] = {4, 8, 6, 0, 2, 0, 1, 15, 12, 0};
        moveZeroEnd(arr2, arr2.length);
        Arrays.stream(arr2).forEach(ele -> System.out.print(ele + " "));
    }

    //0, 0, 8, 5, 10, 0, 0, 20, 0
    public static void moveZero(int arr[]) {
        int startIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                startIndex++;
            } else {
                arr[i - startIndex] = arr[i];
                arr[i] = 0;
            }

        }
    }

    //0, 0, 8, 5, 0, 10, 0, 0, 20, 0
    public static void moveZero1(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                arr[i] = 0;
                count++;
            }

        }
    }

    /**
     * Input: X[] = [4, 8, 6, 0, 2, 0, 1, 15, 12, 0]
     * Output: X[] = [4, 8, 6, 2, 1, 15, 12, 0, 0, 0]
     */

    private static void moveZeroEnd(int[]a, int n) {

        int j = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] != 0) {
                swap(a, j, i);
                j++;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
