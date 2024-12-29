package com.rotatingmind.array.binarysearch_usage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Given an array of integers
 * c
 * i
 * t
 * a
 * t
 * i
 * o
 * n
 * s
 *  where
 * c
 * i
 * t
 * a
 * t
 * i
 * o
 * n
 * s
 * [
 * i
 * ]
 *  is the number of citations a researcher received for their
 * i
 * −
 * t
 * h
 *  paper and
 * c
 * i
 * t
 * a
 * t
 * i
 * o
 * n
 * s
 *  is sorted in an ascending order, compute the researchers
 * h
 * -index.
 *
 * A scientist has an index
 * h
 *  if
 * h
 *  of their
 * n
 *  papers have at least
 * h
 *  citations each, and the other
 * n
 * −
 * h
 *  papers have no more than
 * h
 *  citations each.
 *
 * If there are several possible values for
 * h
 * , the maximum one is taken as the
 * h
 * -index.
 *
 * You must write an algorithm that runs in logarithmic time.
 *
 * Input Format
 *
 * The first line of input contains
 * N
 * , number of elements in the array
 * The second line of input contains
 * N
 *  space-separated integers,
 * c
 * i
 * t
 * a
 * t
 * i
 * o
 * n
 * s
 * [
 * 0
 * ]
 * ,
 * c
 * i
 * t
 * a
 * t
 * i
 * o
 * n
 * s
 * [
 * 1
 * ]
 * ,
 * .
 * .
 * .
 * .
 * .
 * .
 * .
 * ,
 * c
 * i
 * t
 * a
 * t
 * i
 * o
 * n
 * s
 * [
 * N
 * −
 * 1
 * ]
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
 * 5
 * 0
 *
 * ≤
 *
 * c
 * i
 * t
 * a
 * t
 * i
 * o
 * n
 * s
 * [
 * i
 * ]
 *
 * ≤
 *
 * 1000
 * Output Format
 *
 * Print the maximum
 * h
 * -index.
 * Sample Input 0
 *
 * 5
 * 0 1 3 5 6
 *
 * Sample Output 0
 *
 * 3
 *
 * Explanation
 *
 * [
 * 0
 * ,
 * 1
 * ,
 * 3
 * ,
 * 5
 * ,
 * 6
 * ]
 *  means the researcher has
 * 5
 *  papers in total and each of them had received
 * 0
 * ,
 * 1
 * ,
 * 3
 * ,
 * 5
 * ,
 * 6
 *  citations respectively. Since the researcher has
 * 3
 *  papers with at least
 * 3
 *  citations each and the remaining two with no more than
 * 3
 *  citations each, their
 * h
 * −
 * i
 * n
 * d
 * e
 * x
 *  is
 * 3
 * .
 */
public class HIndex2 {

    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        String[] str1 = br.readLine().split(" ");

        for(int i = 0; i < str1.length; i++) {
            a[i] = Integer.parseInt(str1[i]);

        }

        int l = 0;
        int h = n -1;
        int ans = -1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (a[mid] < (n - mid)) {
                l = mid+1;
            }  else if(a[mid] >= (n-mid)) {
                ans = Math.max(ans, n-(int)mid);
                h = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
