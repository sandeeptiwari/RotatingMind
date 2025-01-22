package com.rottaingmind.ds.dp.lecture1;

/**
 * Given int n num of staircase initially, at the bottom want to reach at the top
 *
 * Allow moves:
 *   1- 1 unit jump upword
 *   2- 2 unit moves upword
 *
 *   Need to find number of distinct ways to reach top
 */
public class StairsCaseProblem {


    /**
     * Element of th choices::
     *   from any i pos we can move by 1 or 2 unit jumps toward upwards
     *
     *                  f(0)
     *                   /  \
     *                 f(1) f(2)
     *  i == n return n
     *  i > n return 0
     *
     *  f(i)= f(i+ 1) + f(i+2), i >= 0
     *
     *    OR
     *   f(i) (No of ways to reach from 0 to i)= f(i - 1) + f(i - 2), i >= 0
     *    Termination Condt: if (i == 0) return 1, if (i == -1) return 1
     *
     *  TC & SC = o(n)
     */
    public int totalJumps(int i, int n, int [] a) {
       if (i == n) return n;
       if (i > n) return 0;

       if (a[i] != 0) return a[i];

       int val = totalJumps(i + 1, n, a) + totalJumps(i + 2, n, a);
       a[i] = val;
       return val;
    }

    public static void main(String[] args) {
        int n = 3;
        int f = 1, s = 2;
        if (n == 1) {
            System.out.println(f);
            return;
        }
        for (int i = 3; i < n; i++) {
            int curr = f + s;

            f = s;

            s = curr;
        }
        System.out.println(s);
    }
}
