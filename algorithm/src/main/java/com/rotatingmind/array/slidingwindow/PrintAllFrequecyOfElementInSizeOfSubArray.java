package com.rotatingmind.array.slidingwindow;

public class PrintAllFrequecyOfElementInSizeOfSubArray {

    public static void main(String[] args) {
        int a [] = {1, 2, 2, 2, -1, 0, 2, 4, 2};
        int n = a.length;
        int k = 3;
        int x = 2;
        int freq = 0;
        for (int i = 0; i < k; i++) {
            if (a[i] == x) {
                freq += 1;
            }
        }

        for (int i = k; i < n; i++) {
            System.out.println(freq);
            if (a[i] == x) {
                freq += 1;
            } else if (a[i - k] == 2) {
                freq -= 1;
            }
        }

    }
}
