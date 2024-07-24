package com.rotatingmind.array.binarysearch_usage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given an
 * N
 * ∗
 * M
 *  binary matrix of
 * 1
 * s
 *  (representing soldiers) and
 * 0
 * s
 *  (representing civilians). The soldiers are positioned in front of the civilians. That is, all the
 * 1
 * s
 *  will appear to the left of all the 0 s
 *  in each row. A row i
 *  is weaker than a row  j
 *  if one of the following is true:
 *
 * The number of soldiers in row i
 *  is less than the number of soldiers in row  j
 * Both rows have the same number of soldiers and
 * i<j
 * Print the indices of all the weakest rows in the matrix ordered from weakest to strongest.
 *
 * Input Format
 *
 * The first line of input contains
 * N and  M
 * , denoting rows and columns of the matrix
 * The second line of input contains the binary matrix
 * mat
 * Constraints 1 ≤ N, M ≤ 10 3 0
 *
 * ≤ mat[i] ≤ 1
 * Output Format
 *
 * Print the indices of all the weakest rows in the matrix ordered from weakest to strongest.
 * Sample Input 0
 *
 * 5 5
 * 1 1 0 0 0
 * 1 1 1 1 0
 * 1 0 0 0 0
 * 1 1 0 0 0
 * 1 1 1 1 1
 *
 * Sample Output 0
 *
 * 2 0 3 1 4
 *
 * Explanation
 *
 * The number of soldiers in each row is:
 *
 * Row 0: 2
 * Row 1: 4
 * Row 2: 1
 * Row 3: 2
 * Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 */
public class KWeakestRows {

    public static void main (String[] args) throws java.lang.Exception
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = 5;
        int n = 5;
        int [][] a = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        List<Integer> strengths = new ArrayList<>();

        /*for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(br.readLine());
            }
        }*/

        for(int i = 0; i < m; i++) {
            countSoldiersInRow(a[i], strengths);
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        Collections.sort(indices, Comparator.comparingInt(strengths::get));

        for (int i : indices) {

            System.out.print(i + " ");

        }
    }

    public static void countSoldiersInRow(int[] a, List<Integer> strengths) {
        int n = a.length;
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == 0) {
                high = mid - 1;
            } else {
                if (mid == n - 1) {
                    strengths.add(mid + 1);
                    break;
                } else if (a[mid + 1] == 0) {
                    strengths.add(mid + 1);
                    break;
                } else {
                    low = mid + 1;
                }
            }
        }
    }
}
