package com.rotatingmind.two_pointer;

public class FindThePairSumINSortedArray {


    //Input: Arr[5] = {2, -1, 0,  3, 9}, SUM = 8
    private static boolean isPairSum(int[] a, int target) {
        int l, r;
        int n = a.length - 1;

        for (l = 0, r = n; l < r;) {

            int sum = a[l] + a[r];
            if (sum == target) {
                return true;
            }
            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
       return false;
    }

    private static boolean isPairSumV1(int[] a, int target) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = a[i] + a[j];
                if (sum == target) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 8;
        var hasSum = isPairSumV1(a, target);
        System.out.println("Has pir " + hasSum);
    }
}
