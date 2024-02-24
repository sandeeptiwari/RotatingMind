package com.rotatingmind.array.reverse_lookup;

public class SumOfAllSubArray {

    public static int totalSum(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += getSum(a, i, j);
            }
        }
        return sum;
    }

    public static int getSum(int[] a, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += a[k ];
        }

        return sum;
    }


    public static int totalSumV1(int[] a) {
        int n = a.length;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                ans += sum;
            }
        }
        return ans;
    }

    public static int totalSumV2(int[] a) {
        int n = a.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
           ans += (i+1)*(n-i)*a[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(totalSumV2 (a));
    }
}
