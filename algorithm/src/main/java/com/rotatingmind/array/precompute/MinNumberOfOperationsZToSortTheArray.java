package com.rotatingmind.array.precompute;

public class MinNumberOfOperationsZToSortTheArray {

    /**
     * Approach -1
     * @param a
     * @return
     */
    public static int numOfOps(int[] a) {
        int i = 0, j = 0, ans = 0;
        int len = a.length;

        while (i < len) {
            for (j = i; j < len; j++) {
                if (canBeChunked(a, i, j)) {
                    break;
                }
            }

            i = j + 1;
            ans++;
        }

        return ans;
    }

    //1 2 0 4 3 5
    public static boolean canBeChunked(int[] a, int i, int j) {
        int cout = 0;
        for (int k = i; k < j; k++ ) {
            if (a[k] >= i && a[k] <= j) {
                cout++;
            }
        }

        if (cout == (j - (i + 1))) {
            return true;
        }

        return false;
    }



    /**
     * Approach -2
     * for i = 0 to len-1
     *
     * max = max { cmax, a[i]}
     * cmax == i {ans++}
     */


    public static int minOps(int[] a) {
        int l = a.length;
        int ans = 0, cMax = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            cMax = Math.max(cMax, a[i]);

            if (cMax == i) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 0, 4, 3, 5};
        System.out.println(numOfOps(a));
    }

}
