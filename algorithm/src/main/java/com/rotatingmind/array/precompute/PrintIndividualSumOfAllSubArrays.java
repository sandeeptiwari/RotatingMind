package com.rotatingmind.array.precompute;

public class PrintIndividualSumOfAllSubArrays {

    public void printAllSum(int[] a) {
        int n = a.length;
        int[] ps = new int[n];

        ps[0] = a[0];
        for (int i = 1; i < n; i++) {
            ps[i] = a[i] + ps[i - 1];
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                sum = getSum(ps, i, j);
                System.out.println("Sum " + sum);
            }
        }

    }

    public int getSum(int[] a, int start, int end) {
        return start >= 0 ? a[end] - a[start] : a[start];
    }

    public static void main(String[] args) {
        PrintIndividualSumOfAllSubArrays obj = new PrintIndividualSumOfAllSubArrays();
        int[] a = {1, 2, 3, 4};
        obj.printAllSum(a);
    }

}
