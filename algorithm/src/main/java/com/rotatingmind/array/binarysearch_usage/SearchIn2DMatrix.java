package com.rotatingmind.array.binarysearch_usage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SearchIn2DMatrix {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().trim().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            s = br.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int target = Integer.parseInt(br.readLine().trim());
            boolean flag = false, printed = false;
            for (int i = 0; i < m; i++) {
                int l = 0, h = n - 1;
                if (target >= a[i][l] && target <= a[i][h]) {
                    flag = BinarySearch(a, l, h, target, i);
                    if (flag == true) {
                        printed = true;
                        System.out.println("true");
                        break;
                    } else {
                        printed = true;
                        System.out.println("false");
                        break;
                    }
                } else if ((i < m - 1 && target < a[i + 1][l]) && target > a[i][h]) {
                    System.out.println("false");
                    printed = true;
                    break;
                } else {
                    continue;
                }
            }
            if(printed) continue;
            System.out.println(flag);
        }
    }

    public static boolean BinarySearch(int[][] a, int l, int h, int target, int i) {
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (a[i][m] == target) {
                return true;
            } else if (a[i][m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
