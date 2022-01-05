package com.rotatingmind.mix;

import java.util.Arrays;

public class B {
    static A a;
    static int get() {
        return a.getX();
    }
    public static void main(String[] args) {
        /*int a = 20, b = 10, c = 5, d = 5;
        if (((a > b) && (c <= d)) || ((a <= b) && (c > d))) {
            System.out.println("Hi");
        }

        if ((a < b) == (c < d)) {
            System.out.println("Hi");
        }*/
        int arr[] = {3, 134, 25, 1, 22, 90, 11};
        // BubbleSortRecursive(arr);

        Arrays.stream(arr).forEach(System.out::print);
    }

    public static int solve(int[] array, int n) {
        int temp = 1;
        int sum = 0;

        for (int i = 1; i < n; i++) {
            sum += array[i];

            if (array[i] % 2 == 0) {
                temp = Math.min(temp, array[i]);
            }
            if (sum % 2 != 0) {
                sum -= temp;
            }
        }


        return sum;
    }

    public static void BubbleSortRecursive(int[] numbers, int length) {
    }

    static void bubbleSortRecursive(int data [], int i, int max) {

        System.out.println(data);

        if(i == max-1) {
            max--;
            i = 0;
        }

        if (i < max-1) {
            if (data[i] > data[i+1]) {
                data[i] = data[i+1];
               // data[i+1], data[i]
            }
            bubbleSortRecursive(data, i+1, max);
        }
    }
}
