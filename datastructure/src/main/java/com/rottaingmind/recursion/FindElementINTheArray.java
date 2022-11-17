package com.rottaingmind.recursion;

public class FindElementINTheArray {

    private static int find(int[]arr, int ele, int start) {
        if ((arr == null || arr.length == 0) || arr.length >= start) {
            return -1;
        }
        if (arr[start] == ele)
            return start;

        return find(arr, ele, start + 1);
    }

    private static int findOptimize(int[]arr, int ele, int left, int right) {
        int mid = (left + right) / 2;

        if (left >= right) return -1;

        if (arr[mid] == ele) {
            return mid;
        } else if (ele < arr[mid]) {
            return findOptimize(arr, ele, left, mid-1);
        }

        return findOptimize(arr, ele, mid + 1, right);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 4, 6, 7, 8, 11, 14, 15, 16, 18, 19};
        System.out.println(findOptimize(arr, 6, 0, arr.length));
    }
}
