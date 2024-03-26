package com.rotatingmind.twod_array;

public class SumOfAllSubMatrix {

    public static int sum(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int ans = 0;

        //top left
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                //bottom right
                for (int k = 0; k < n; k++) {

                    for (int l = 0; l < n; l++) {
                         ans += getSum(a, i, j, k, l);
                    }
                }
            }
        }
        return ans;
    }

    private static int getSum(int[][] a, int i1, int i2, int j1, int j2) {
        int sum = 0;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                sum += a[i][j];
            }
        }
        return sum;
    }

    /** if matrix in n X m
     * num of choices for Top Left Cell = (i +1) * (j + 1)
     * num of choices for Top Right Cell = (n - i) * (n - j)
     *
     * So if we talk about ele (i, j), these element will be part of these many sub-matrixes
     *  = (i +1) * (j+1) * (n-i) * (n-j)
     *  contrin of a[i, j] = (i +1) * (j+1) * (n-i) * (n-j) * a[i, j]
     * @return
     */
    public static int sumV1(int[][] a) {
        int n = a.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
             ans += (i + 1) * (j + 1) * (n-i) *(n-j) * a[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1}, {1, 1}};
        int res = sumV1(a);
        System.out.println(res);
    }
}
