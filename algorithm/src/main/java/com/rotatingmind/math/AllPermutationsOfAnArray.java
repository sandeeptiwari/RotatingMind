package com.rotatingmind.math;

public class AllPermutationsOfAnArray {

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }


    public static void permute(int[] arr, int i, int len) {
        if (len == i) {
            printArray(arr);
            return;
        }

        for (int j = i; j <= len; j++) {
            swap(arr, i, j);
            permute(arr, i + 1, len);
            swap(arr, i, j);
        }
    }

    private static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr, 0, arr.length - 1);
    }
}
