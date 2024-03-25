package com.rotatingmind.array.binarysearch_usage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice {

    public static int firstOcc(int key, int[] arr) {
        int n = arr.length;
        int l = 0, h = n, m = 0;
        while(l <= h) {
            m = (l + h) / 2;

            if (arr[m] > key) {
                h = m - 1;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                if (m == 0) return m;
                if (arr[m -1] != key) return m;
                else {
                    h = m - 1;
                }
            }
        }
        return m;
    }

    public static int lastOcc(int key, int[] arr) {
        int n = arr.length;
        int l = 0, h = n, m = 0;
        while(l <= h) {
            m = (l + h) / 2;

            if (arr[m] > key) {
                h = m - 1;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                if (m == n -1) return m;
                if (arr[m + 1] != key) return m;
                else {
                   l = m + 1;
                }
            }
        }
        return m;
    }

    public static int[] intersectionOFArray(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        int[] parent = n1 > n2 ? a1 : a2;
        int[] child = n1 < n2 ? a1 : a2;
        Arrays.sort(parent);

        Set<Integer> results = new HashSet<>();

        for (int i = 0; i < child.length; i++) {

            if(findElement(parent, child[i])) {
                results.add(child[i]);
            }
        }

        int[] res = new int[results.size()];
        int i = 0;
        for (int ele : results) {
            res[i] = ele;
            i++;
        }
        return res;
    }


    public static boolean findElement(int[] a, int ele) {
        int n = a.length;
        int l = 0, h = n;
        int mid = 0;

        while(l < h) {
            mid = (l + h) / 2;

            if (a[mid] == ele) {
                return true;
            } else if (ele < a[mid]) {
                h = mid-1;
            } else if (ele > a[mid]) {
                l = mid + 1;
            }
        }
        return false;
    }







    public static void main(String[] args) {
        /*int arr[] = {1, 2, 2, 5, 5, 5, 5, 5, 9, 11};
        int firstOcc = firstOcc(5, arr);
        int lastOcc = lastOcc(5, arr);
        System.out.println("First occ " + firstOcc);
        System.out.println("Last occ " + lastOcc);
        System.out.println("Number of ele " + (lastOcc - firstOcc + 1));*/
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] a = intersectionOFArray(nums1, nums2);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

}
