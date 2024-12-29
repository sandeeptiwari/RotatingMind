package com.rotatingmind.array.binarysearch_usage;

/**
 * Peak :
 *  i - ele >= right ele
 *  ii- ele <= left ele
 *
 *  Any peak element
 *
 *
 *  All element comes single time while single element which will comes twice and array is sorted
 *  e.g  [1, 2, 3, 4, 5, 5, 6, 7]
 */

public class RepeatElementInArray {


    public static void main(String[] args) {
        //int [] a = {1, 2, 3, 4, 5, 5, 6, 7};
        int [] a = {1, 2, 3, 4, 4, 5, 6};
        int n = a.length;
        int l = 0;
        int h = n;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (a[mid] == mid) {  // value is equal to index itself e.g. at index 5 we have 5 at index 6 we have 6 so on so forth
                h = mid -1; // it means first occurance of value always occurs left side
            } else  {
                if (a[mid] == a[mid + 1]) {
                    System.out.println("mid value " + mid);
                    break;
                } else {
                    l = mid + 1;
                }
            }
        }
    }
}
