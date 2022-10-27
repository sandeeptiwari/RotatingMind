package com.rotatingmind.array;

import java.util.Arrays;

public class MaxThreeElements {

    public static void main(String...args){
        int k = 3;// 9910678434
        int temp = 0;

        int arr[] = {1, 23, 12, 9, 30, 2, 50};
        printMaxThreeElementV1(arr);
        /*for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if(arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(arr[i]);
        }*/

    }

    public static void printMaxThreeElementV1(int arr[]) {
        Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> b - a)
                .limit(3)
                .forEach(System.out::println);
    }
    public static void printMaxThreeElementV2(int arr[]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arr.length; j++) {

            }
        }

    }
}
