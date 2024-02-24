package com.rotatingmind.array.precompute;

/**
 * Max of p*a[i] + q*a[j] + r*a[k]
 */
public class MarvoloRing {

    public static int maxOfExpression(int[] a, int p, int q, int r) {
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int[] pPrefMax = new int[n];
        int[] rPrefMax = new int[n];

        pPrefMax[0] = p * a[0];
        for (int i = 1; i < n; i++) {
            pPrefMax[i] = Math.max(pPrefMax[i-1], p*a[i]);
        }

        rPrefMax[n-1] = r * a[n-1];
        for (int i = n - 2; i >=0 ; i--) {
            rPrefMax[i] = Math.max(rPrefMax[i+1], r*a[i]);
        }

        for (int i = 0; i < n; i++) {
            int res = pPrefMax[i] + q * a[i] + rPrefMax[i];
            max = Math.max(max, res);
        }

        return max;
    }


    public static int maxProduct(int[] a, int p, int q, int r) {
        int n = a.length;
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];

        // Precompute maximum values from left and right
        maxLeft[0] = a[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(p * a[i], maxLeft[i - 1]);
        }

        maxRight[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(r * a[i], maxRight[i + 1]);
        }

        // Find the maximum value for any combination of i, j, k
        int max = Integer.MIN_VALUE;
        for (int j = 1; j < n - 1; j++) {
            int leftMax = maxLeft[j - 1];
            int rightMax = maxRight[j + 1];
            max = Math.max(max, leftMax + q * a[j] + rightMax);
        }

        return max;
    }

    private static long maximizeExpUpdated(int[] arr,int n, long p, long q, long r) {
        long lMax[] = new long[n];
        lMax[0] = p*arr[0];
        for(int i = 1;i<n;i++) {
            lMax[i] = Math.max(lMax[i - 1], p * arr[i]);
        }
        long[] rMax = new long[n];
        rMax[n-1] = r*arr[n-1];
        for(int i = n-2;i>=0;i--){
            rMax[i] = Math.max(rMax[i+1],r*arr[i]);
        }
        long max = Long.MIN_VALUE;
        for(int i = 0;i<n;i++){
            max = Math.max(max,lMax[i]+rMax[i]+q*arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(maxOfExpression(a, 1, 2, 3));
    }
}
