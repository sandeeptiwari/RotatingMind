package com.rotatingmind.array.precompute;

public class Practice {


    public static void main(String[] args) {
        int a[] = {0, 1, 0, 2, 1, 3, 0, 2};
        int res = maxExp(a, 1, 2, 3);
        System.out.println("Res :: " + res);
    }

    /**
     * Max of p*a[i] + q*a[j] + r*a[k]
     */
    public static int maxExp(int[] a, int p, int q, int r) {
        int n = a.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = p * a[0];
        suffix[n - 1] = r * a[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], p * a[i]);
        }

        for (int i = n - 2; i >= 0; i++) {
            suffix[i] = Math.max(suffix[i + 1], r * a[i]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, prefix[i] + q * a[i] + suffix[i]);
        }
        return max;
    }

}
