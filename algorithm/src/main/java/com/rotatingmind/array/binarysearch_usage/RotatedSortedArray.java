package com.rotatingmind.array.binarysearch_usage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * You have been given an integer array
 * n
 * u
 * m
 * s
 *  sorted in ascending order with distinct values.
 * n
 * u
 * m
 * s
 *  is rotated at an unknown pivot index
 * k
 *  (
 * 0
 *
 * ≤
 *
 * k
 *
 * <
 *
 * n
 * u
 * m
 * s
 * .
 * l
 * e
 * n
 * g
 * t
 * h
 * ) such that the resulting array is
 * [
 * n
 * u
 * m
 * s
 * [
 * k
 * ]
 * ,
 * n
 * u
 * m
 * s
 * [
 * k
 * +
 * 1
 * ]
 * ,
 * .
 * .
 * .
 * ,
 * n
 * u
 * m
 * s
 * [
 * n
 * −
 * 1
 * ]
 * ,
 * n
 * u
 * m
 * s
 * [
 * 0
 * ]
 * ,
 * n
 * u
 * m
 * s
 * [
 * 1
 * ]
 * ,
 * .
 * .
 * .
 * ,
 * n
 * u
 * m
 * s
 * [
 * k
 * −
 * 1
 * ]
 * ]
 *  (0-indexed).
 *
 * For example,
 * [
 * 0
 * ,
 * 1
 * ,
 * 2
 * ,
 * 4
 * ,
 * 5
 * ,
 * 6
 * ,
 * 7
 * ]
 *  might be rotated at pivot index
 * 3
 *  and become
 * [
 * 4
 * ,
 * 5
 * ,
 * 6
 * ,
 * 7
 * ,
 * 0
 * ,
 * 1
 * ,
 * 2
 * ]
 * .
 *
 * Given the array
 * n
 * u
 * m
 * s
 *  after the rotation and an integer
 * t
 * a
 * r
 * g
 * e
 * t
 * , print the index of
 * t
 * a
 * r
 * g
 * e
 * t
 *  if it is in
 * n
 * u
 * m
 * s
 * , or
 * −
 * 1
 *  if it is not in
 * n
 * u
 * m
 * s
 * .
 *
 * You must write an algorithm with
 * O
 * (
 * l
 * o
 * g
 * n
 * )
 *  runtime complexity.
 *
 * Input Format
 *
 * The first line of input contains
 * N
 * , size of the array
 * The second line of input contains
 * N
 *  space-separated array elements
 * n
 * u
 * m
 * s
 * [
 * 0
 * ]
 * ,
 * .
 * .
 * .
 * .
 * .
 * .
 * .
 * .
 * ,
 * n
 * u
 * m
 * s
 * [
 * N
 * −
 * 1
 * ]
 * The third line of the input contains a single integer
 * T
 *  denoting the number of test cases. The description of
 * T
 *  test cases follows.
 * Each test case consists of a positive integer
 * t
 * a
 * r
 * g
 * e
 * t
 * Constraints
 *
 * 1
 *
 * ≤
 *
 * N
 *
 * ≤
 *
 * 10
 * 4
 * −
 * 10
 * 4
 *
 * ≤
 *
 * n
 * u
 * m
 * s
 * [
 * i
 * ]
 * ,
 * t
 * a
 * r
 * g
 * e
 * t
 *
 * ≤
 *
 * 10
 * 4
 * 1
 *
 * ≤
 *
 * T
 *
 * ≤
 *
 * 10
 * 5
 * Output Format
 *
 * For each testcase, print the index if the
 * t
 * a
 * r
 * g
 * e
 * t
 *  is found. If not, print
 * −
 * 1
 * .
 * Sample Input 0
 *
 * 7
 * 4 5 6 7 0 1 2
 * 2
 * 0
 * 3
 *
 * Sample Output 0
 *
 * 4
 * -1
 */
public class RotatedSortedArray {

    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String arrInuptStr = br.readLine();
        String[] s = arrInuptStr.split(" ");
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }


        int t = Integer.parseInt(br.readLine());
        int[] target = new int[t];

        for (int i = 0; i < t; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        int pivoteIndex = getPivoteIndex(a, n);

        for (int i = 0; i < target.length; i++) {
            int tt = target[i];

            int res = find(a, 0, pivoteIndex, tt);
            if (res == -1) {
                res = find(a, pivoteIndex, n - 1, tt);
            }
            System.out.println(res);
        }

    }


    public static int find(int[] a, int start, int end, int target) {
        int l = start;
        int h = end;

        while (l <= h) {

            int mid = (l + h) / 2;

            if (target == a[mid]) {
                return mid;
            } else if (target < a[mid]) {
                h = mid -1;
            } else if (target > a[mid]) {
                l = mid + 1;
            }
        }
        return -1;
    }


    public static int getPivoteIndex(int[] a, int n) {
        int l = 0;
        int h = n -1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (a[mid] < a[n-1]) {
                h = mid - 1;
            } else {

                if (mid == 0 && a[mid] > a[mid + 1]) {
                    return mid;
                } else if (a[mid] > a[mid + 1]) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }


}
