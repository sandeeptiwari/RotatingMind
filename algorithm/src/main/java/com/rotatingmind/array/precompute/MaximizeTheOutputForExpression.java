package com.rotatingmind.array.precompute;

/**
 * int a[]
 * int p, q, r
 * max( p*a[i] + q*a[j] + r*a[k] )
 *  where i < j < k
 */
public class MaximizeTheOutputForExpression {


    public static int calculateMaxV0(int[] a, int p, int q, int r) {
        int l = a.length;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < l; i++) {

            for (int j = i + 1; j < l; j++) {

                for (int k = j + 1; k < l; k++) {

                    answer = Math.max(answer, (p * a[i] + q * a[j] + r * a[k]));
                }

            }

        }

        return answer;
    }


    public static int calculateMax(int[] a, int p, int q, int r) {
        int l = a.length;
        int[] prefixMax = new int[l];
        int[] suffixMax = new int[l];
        int answer = Integer.MIN_VALUE;

        prefixMax[0] = p*a[0];
        suffixMax[l-1] = r*a[l-1];

        for (int i = 1; i < l; i++) {
            prefixMax[i] = Math.max(prefixMax[i -1], p * a[i]);
        }

        for (int i = l-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], r * a[i]);
        }

        for(int i = 1;i < l; i++){
            answer= Math.max(answer,prefixMax[i]+q*a[i]+suffixMax[i]);

        }
        return answer;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        int p = 1, q = 2, r = 3;

        System.out.println(calculateMax(a, p, q, r));
    }
}
