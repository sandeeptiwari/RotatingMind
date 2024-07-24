package com.rotatingmind.array.binarysearch_usage;

import java.util.Arrays;

/**
 * Given n book,
 * each books # page in books (p0, p1, p2, p3,...pn-1)
 * #students = m
 *
 * we have to allocate n books to m students by taking care below criteria:
 *
 * 1. each students must get at-least 1 books
 * 2. all the books should be allotted
 * 3. allotment must be contiguous
 *
 * p1, p2, p3, p4, p5, p6, p7
 *
 * maximum no of pages to allocated to any student must be minimized
 *
 * e.g. m = 2
 * a == {12, 34, 67, 90}
 * allcation1
 * style 1 : max (1 = 12,  2 = 191) = 191
 * style 2 : max (1 = 46,  2 = 157) = 157
 * style 3 : max (1 = 131, 2 = 90 ) = 113
 * min(191, 157, 113 ) = 113 is ans.
 *
 * we have to minimize maximum number of pages which student gets
 * low = max of element
 * high = sum of page of array
 * */
public class AllocateBooks {

    public static boolean isPoss1(int[] a, int mid, int m) {
        int c = 1, sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (sum + a[i] > mid) {
                c++;
                sum = a[i];
            } else {
                sum += a[i];
            }
        }
        return c <= m; // number of student is used < that actual student need to allocate
    }

    public static int allocation(int[] books, int studs) {
        int l = Arrays.stream(books).max().getAsInt();;//max of (books)
        int h = Arrays.stream(books).sum();; // sum of all ele of books

        while (l <= h) {
            int mid = l + (h -l) / 2;

            boolean r = isPoss(books, mid, studs);

            if (!r) {
                l = mid + 1;
            } else {
                boolean r1 = isPoss(books, mid - 1 , studs);

                if (!r1) return mid;
                else {
                    h = mid - 1;
                    if (h < l) {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }

    public static int splitArray(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 0 ) {
            return 0;
        }

        int l = Arrays.stream(nums).max().getAsInt();
        int h = Arrays.stream(nums).sum();

        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPoss(nums, mid, k)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPoss(int[] a, int mid, int m) {
        int cnt = 1;
        int sum = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            if (sum + a[i] > mid) {
                cnt++;
                sum = a[i];
            } else {
                sum += a[i];
            }
        }
        return cnt <= m;
    }

    public static void main(String[] args) {
        //int[] a = {1, 2, 3, 4, 5};
        //int[] a = {2,3,1,2,4,3};
        //int [] a = {1,4,4};
        int a[] = {2,3,1,1,1,1,1}; //3
        //int allocation = splitArray(a, 5);
        int allocation = allocation(a, 5);
        System.out.println("Min allotted book " + allocation);
    }
}
