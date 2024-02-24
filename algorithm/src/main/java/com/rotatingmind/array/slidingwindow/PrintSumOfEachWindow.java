package com.rotatingmind.array.slidingwindow;

public class PrintSumOfEachWindow {

    public static void main(String[] args) {
        int a [] = {1, 2, -1, 0, 4};
        int n = a.length;
        int k = 3;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum +=a[i];
        }

        for (int i = k; i < n; i++) {
            System.out.println(sum);

            sum += a[i];
            sum -= a[i - k];
        }

        System.out.println(sum);

        //brute force
        /*for (int i = 0; i <= n-k; i++) {
             sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += a[j];
            }
            System.out.println(sum);
        }*/
    }
}
