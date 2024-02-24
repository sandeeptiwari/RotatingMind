package com.rotatingmind.array.slidingwindow;

public class SumOfAllSubArray {

    public static void main(String[] args) {
        int a [] = {1,2,3};
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += a[i];
            }
        }
    }
}
