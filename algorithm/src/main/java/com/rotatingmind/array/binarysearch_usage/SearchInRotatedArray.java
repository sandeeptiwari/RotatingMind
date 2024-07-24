package com.rotatingmind.array.binarysearch_usage;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int [] a = {5, 6, 7, 1, 2, 3, 4};
        int n = a.length;
        int l = 0;
        int h = n - 1;
        int index = -1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (a[mid] <= a[n -1]) {
                h = mid - 1;
            } else if (a[mid] > a[n -1]) {
                if (mid == 0) {
                    index = mid;
                    break;
                } else if (a[mid] > a[mid + 1] ) {
                    index = mid;
                    break;
                } else {
                    l = mid + 1;
                }
            }
        }

        System.out.println(" Index ==> " + index);
    }
}
