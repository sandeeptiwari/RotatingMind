package com.rotatingmind.array;

import java.util.Arrays;

public class MoveAllZeroToTheEndMaintainOrder {

    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 8, 7, 5, 0, 10, 0, 0, 20, 0};
        int arr1[] = {0, 1, 0, 0, 0, 10};
        moveZero1(arr);

        Arrays.stream(arr).forEach(ele -> System.out.print(ele + " "));
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
}
