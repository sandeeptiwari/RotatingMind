package com.rotatingmind.backtracking;

import static com.rotatingmind.string.PermutationWithDuplicateNums.swap;

/**
 * Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed)
 * is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 *
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1,2]:
 *     - perm[1] = 1 is divisible by i = 1
 *     - perm[2] = 2 is divisible by i = 2
 * The second beautiful arrangement is [2,1]:
 *     - perm[1] = 2 is divisible by i = 1
 *     - i = 2 is divisible by perm[2] = 1
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 */
public class BeautifulArrangement {

    public static int countArrangement(int n) {

        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }

        //Set<List<Integer>> com = new HashSet<>();
        //countArrangement(a, 1, com);
        return countArrangement(a, 1);
        //return com.size();
    }

    //public static void countArrangement(int[] a, int i, Set<List<Integer>> res) {
    public static int countArrangement(int[] a, int i) {
        int n = a.length;
        if (i == a.length) {
            return 1;
        }

        int ans = 0;

        for (int j = i; j < n; j++) {
            swap(a, i, j);
            if (a[i] % i == 0 || i % a[i] == 0) {
                ans += countArrangement(a, i + 1);
            }
            swap(a, i, j);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(countArrangement(3));
    }

}
