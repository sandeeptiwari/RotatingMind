package com.rotatingmind.array.hashmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * check if there is subarray with sum == 0
 * [6, -1, 2, 1, -1] 
 */
public class SubArrayWithGivenSum {

   /* public static void main(String[] args) {
        //int[] a = {6, -1, 2, 1, -1};
        //int[] a = {1, 2, 3, -6};
        int[] a = {4,2, -3, 1, 6};
        System.out.println(usingHashTable(a));
    }*/

    /**
     * 2
     * 5
     * 4 2 -3 1 6
     * 5
     * 4 2 4 1 6
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

            Map<Integer, Integer> map = new HashMap<>();
            int ps = 0;
            map.put(0, 1);
            boolean found = false;

            for(int j = 0; j < n; j++) {
                ps = ps + a[j];
                if (map.containsKey(ps)) {
                    found = true;
                    break;
                }
                map.put(ps, 1);
            }

            if (found) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }



    }

    //o(n^2)
    public static boolean bruteForce(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;

            for (int j = i + 1; j < n; j++) {
                sum += a[j];

                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * if ever happen, if prefix sum till a[i] == prefix sum till a[j] it means that
     * sum of subarray between a[i] & a[j] would be zero
     *
     * Now we can use hashtable to store prefix
     *
     * Edge Case: If prefix sum is equal to zero of entire array like, in that case PS wont get repeat as:
     *
     * a = [1, 2, 3, -6]
     * PS = [1, 3, 6, 0]  ==> we have to put 0 key as default now you can see [0, 1, 3, 6, 0] repeatation
     *
     * o(n) : solution now if sum = k then we have to change ==> if (psMap.containsKey(ps)) to if (psMap.containsKey(ps - k))
     */
    public static boolean usingHashTable(int[] a) {
        Map<Integer, Integer> psMap = new HashMap<>();
        int n = a.length;
        psMap.put(0, 1); // value can we anything here
        int ps = 0;

        for (int i = 0; i < n; i++) {
            ps = ps + a[i];
            if (psMap.containsKey(ps)) {
                return true;
            }
            psMap.put(ps, 1);
        }
        return false;
    }


}
