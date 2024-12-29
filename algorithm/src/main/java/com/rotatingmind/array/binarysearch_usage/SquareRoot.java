package com.rotatingmind.array.binarysearch_usage;

import java.util.Scanner;

public class SquareRoot {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc > 0) {

            long n = sc.nextLong();

            System.out.println(sqrt(n));

            tc--;

        }
    }

    /**
     * sqrt of any number is always greater than -> 0
     * y = x^2 right part  of this graph would be increasing in nature
     *
     * @param num
     * @return
     */
    private static long sqrt(long num) {

        long l = 0, r = num;

        while (l <= r) {
            long mid = (l + r) / 2;

            if ((mid * mid) > num) {
                r = mid - 1;
            } else {

                if ((mid + 1) * (mid + 1) > num) {
                    return mid;
                } else {

                    l = mid + 1;

                }
            }
        }

        return -1;
    }
}
