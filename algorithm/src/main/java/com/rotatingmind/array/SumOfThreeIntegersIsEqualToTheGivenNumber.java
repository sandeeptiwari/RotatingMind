package com.rotatingmind.array;

import java.util.Arrays;

public class SumOfThreeIntegersIsEqualToTheGivenNumber {

    private static boolean findSumOfTwo(int[] arr, int val, int startIndex) {
        for (int i = startIndex, j = arr.length - 1; i < j; ) {
            int sum = arr[i] + arr[j];

            if (sum == val) {
                return true;
            }

            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }

    public static Boolean findSumOfThreeV3(int arr[], int requiredSum) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; ++i) {
            int remainingSum = requiredSum - arr[i];
            if (findSumOfTwo(arr, remainingSum, i + 1)) {
                return true;
            }
        }
        return false;
    }

    //int[] arr = {-25, -10, -7, -3, 2, 4, 8, 10};
    public static void main(String[] args) {
        int[] arr = {-25, -10, -7, -3, 2, 4, 8, 10};
        System.out.println("-8: " + findSumOfThreeV3(arr, -8));
        System.out.println("-25: " + findSumOfThreeV3(arr, -25));
        System.out.println("0: " + findSumOfThreeV3(arr, 0));
        System.out.println("-42: " + findSumOfThreeV3(arr, -42));
        System.out.println("22: " + findSumOfThreeV3(arr, 22));
        System.out.println("-7: " + findSumOfThreeV3(arr, -7));
        System.out.println("-3: " + findSumOfThreeV3(arr, -3));
        System.out.println("2: " + findSumOfThreeV3(arr, 2));
        System.out.println("4: " + findSumOfThreeV3(arr, 4));
        System.out.println("8: " + findSumOfThreeV3(arr, 8));
        System.out.println("7: " + findSumOfThreeV3(arr, 7));
        System.out.println("1: " + findSumOfThreeV3(arr, 1));
    }
}
