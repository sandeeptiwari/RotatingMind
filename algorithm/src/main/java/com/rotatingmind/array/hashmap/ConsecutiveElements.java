package com.rotatingmind.array.hashmap;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Check if array contains consecutive elements::
 * [19, 16, 12, 15, 14] if we sort in acs order [12, 13, 14, 15, 16], and after sorting if ele comes in consecutive manner
 *
 * like a0, a1, a2, a3, a4, a5....an-1
 *
 * e.g.
 * [5, 3, 2, 1, 4] => [1, 2, 3, 4, 5] => T
 * [34, 23, 52, 12, 11] => [11, 12, 23, 34, 52] => F
 * [7, 6, 5, 5, 3, 4] => [3, 4, 5, 5, 6, 7] => F
 *
 *
 */
public class ConsecutiveElements {

    /**
     * if array is consecutive then max - min = N -1 but thi swill not work if duplicate ele exist
     */
    public static boolean isEleInConsecutiveOrder(int[] a) {
        int n = a.length;
        Map<Integer, Integer> eleMap = new HashMap<>();
        int minEle = Arrays.stream(a).min().getAsInt();
        for (int i = 0; i < n ; i++) {
            eleMap.merge(a[i], 1, Integer::sum);
        }

        for (int i = minEle; i < (minEle + n - 1); i++) {
            if (eleMap.get(a[i]) > 1) {
                return false;
            } else {
                if(!eleMap.containsKey(minEle + i)) {
                   return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 2, 1, 4};
        int[] a1 = {7, 6, 5, 5, 3, 4};
        boolean eleInConsecutiveOrder = isEleInConsecutiveOrder(a1);
        System.out.println("Is Consecutive :: " + eleInConsecutiveOrder);
    }

}
