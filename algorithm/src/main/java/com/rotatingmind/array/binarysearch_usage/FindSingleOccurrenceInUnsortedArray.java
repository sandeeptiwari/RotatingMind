package com.rotatingmind.array.binarysearch_usage;

/**
 * All ele come in a pair together but only one ele comes exact 1 times
 * e.g. 4,4,1,1,3,7,7,6,6
 * now we have one property after/before single Occurrence ele if you will see in closure look 1st Occurrence of
 * ele comes at even index and sec Occurrence comes at odd index till that's element means left part whereas
 * right side of element pattern gets change and 1st occ at odd index and second Occurrence at even index
 */

public class FindSingleOccurrenceInUnsortedArray {


    public static void main(String[] args) {
        int[] a = {4, 4, 1, 1, 3, 5, 5, 7, 7, 6, 6};
        int n = a.length;
        int l = 0;
        int h = n - 1;

        if (l == h) {
            System.out.println(" Its ele at " + l + " Ele " + a[l]);
            return;
        }

        while (l <= h) {
            int mid = (l + h) / 2;

            if (mid == 0) {
                if (a[mid] != a[mid + 1]) {
                    System.out.println(" Its ele at " + mid + " Ele " + a[mid]);
                    break;
                } else {
                    l = mid + 1;
                }
            } else if (mid == n - 1) {
                if (a[mid] != a[mid - 1]) {
                    System.out.println(" Its ele at " + mid + " Ele " + a[mid]);
                    break;
                } else {
                    h = mid - 1;
                }
            } else if (a[mid] != a[mid - 1] && a[mid] != a[mid + 1]) {
                System.out.println(" Its ele at " + mid + " Ele " + a[mid]);
                break;
            } else if ((mid % 2 == 0 && a[mid] == a[mid + 1]) || (mid % 2 != 0 && a[mid] == a[mid - 1])) {
                l = mid + 1;
            } else if ((mid % 2 != 0 && a[mid] == a[mid + 1]) || (mid % 2 == 0 && a[mid] == a[mid - 1])) {
                h = mid - 1;
            }
        }
    }

}
