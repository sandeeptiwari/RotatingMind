package com.rotatingmind.array.hashmap;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * find the length of longest subarray with sum zero
 * a[] = {2, 1, 4, -3, -2, 3, -1, -2, 6}
 * here sum of subarray from index 1, index len -1 :: {1, 4, -3, -2, 3, -1, -2}
 *
 * we have to prepare PS = 2, 3, 7, 4, 2, 5, 4, 2, 8
 *                   idx = 0, 1, 2, 3, 4, 5, 6, 7, 8
 *
 * Here is prefix sum is repeating  = 2, 4 but subarray len 2 > 4
 *
 * Edge Case :
 *         0, 1, 2, 2 -5
 * index = -1, 0, 1, 2, 3
 */
public class LongestSubarrayWithGivenSum {

   /* public static void main(String[] args) {
        int[] a = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        System.out.println(sumEqualToK(a, k));
    }*/

    private static void subarraySumEqualToZero() {
        int[] a = {2, 1, 4, -3, -2, 3, -1, -2, 6};
        int n = a.length;
        Map<Integer, Integer> psMap = new HashMap<>();
        psMap.put(0, -1);
        int ans = 0;
        int ps = 0;

        for (int i = 0; i < n; i++) {

            ps += a[i];

            if (!psMap.containsKey(ps)) {
                psMap.put(ps, i);
            } else {
                ans = Math.max(ans, i - psMap.get(ps));
            }

        }
        System.out.println("Max Len " + ans);
    }

    public static int sumEqualToK(int[] a, int k) {
        int n = a.length;
        Map<Integer, Integer> psMap = new HashMap<>();
        psMap.put(0, -1);
        int ans = 0;
        int ps = 0;

        for (int i = 0; i < n; i++) {

            ps += a[i];

            if (psMap.containsKey(ps - k)) {
                ans = Math.max(ans, i - psMap.get(ps - k));
            }
            if (!psMap.containsKey(ps)) {
                psMap.put(ps, i);
            }

        }
        System.out.println("Max Len " + ans);
        return ans;
    }


    /**
     * @param args
     * @throws java.lang.Exception
     */
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String[] s = br.readLine().split(" ");

            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(s[j]);
            }

            Map<Integer, Integer> psMap = new HashMap<>();
            psMap.put(0, -1);
            int ans = 0;
            int ps = 0;

            for (int k = 0; k < n; k++) {
                ps += a[k];

                if (!psMap.containsKey(ps)) {
                    psMap.put(ps, k);
                } else {
                    ans = Math.max(ans, (psMap.get(ps) - k));
                }
            }

            System.out.println(ans);
        }
    }
}
