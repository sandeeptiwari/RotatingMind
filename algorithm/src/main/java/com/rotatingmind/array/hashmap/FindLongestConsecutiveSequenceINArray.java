package com.rotatingmind.array.hashmap;


import java.util.*;

import static com.rotatingmind.array.hashmap.ConsecutiveElements.isEleInConsecutiveOrder;

/**
 * Check if the length of longest consecutive sequence::
 * E.g. [10, 3, 7, 9, 5, 4, 16, 20, 6, 5, 19]
 *
 * ==> Pick any element of your choice and arrange them in asc order, after that if they follow consecutive rule it means
 * sequence is consecutive sequence
 *
 * no line -|--|--|--|--|-----|--|------------|------|--|------------------------------------------------------------------------------------
 *          3  4  5  6  7     9  10           16     19  20
 *
 * longest sequence would be 3, 4, 5, 6, 7, if we sort the array then we can see consecutive some would be in consecutive
 *
 * 1- if we sort the array will get chunk of ele which are form consecutive arr
 * 2- Now we have to remove duplicate elements from arr
 * 3-
 */
public class FindLongestConsecutiveSequenceINArray {


    /**
     * TC = sorting = nlogn
     * o(nlogn)
     */
    public static int longestConsecutiveSequenceV1(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int[] temp = new int[n];
        temp[0] = a[0];
        int k = 1;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] == a[i]) {
                continue;
            }
             temp[k++] = a[i];
        }

        int cnt = 1;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (temp[i] + 1 == temp[i + 1]) {
                cnt++;
            } else {
                ans = Math.max(cnt, ans);
                cnt = 0;
            }
        }

        return ans;
    }



    /**
     * streak = size of consecution elements
     * 2, 3, 4, x 6, 7, 8, 9
     * left_streak(ls) = str(x-1)
     * right_streak(rs) = str(x+1)
     *  value = 1 + ls + rs
     *  NOw stream of 2 and now should be change as 8
     *
     *  streak of border must be updated correctly
     *
     *  lf = x - ls = > 5 - 3 = 2
     *  rs = x + rs =>
     *
     *  5, 11, 3, 2, 6, 4
     *
     *  --|-----|----------------------------|--------------------|--------------------
     *    2     3                            5                   11
     *
     *   streak of x = 5, x- 1 and x  + 1
     *   streak(4) = 0 because 4 doesnt present in array
     *   streak(5 +1) = 0, because on no line 6 is not present initially
     *
     *   val = 1 + 0  + 0 = 1
     *
     *   streak(5) = 1
     *
     *   now in map we have to update streak for border elements
     *
     *   left_border = x - ls = 5 - 0
     *   rightBorder = x + rs = 5 + 0
     *
     *  Now 11, so streak(11) = 1 + ls(11-1) + rs(11+1) = 1 + 0 (10 is not avai) + 0 (9 is not avai)
     *                        = 1
     *
     * for 2, we need to calculate
     * ls = streak(2-1) = str(1) = because is not there
     * rs = streak (2+1) = streak(3) = 1
     * val = 1 + ls + rs
     * not update border ele with val
     * border elements=
     * le = x - ls = 2 - 0
     * rEl = x + rs = 2 + 1
     *
     * in map 2 -> 2 (val is 2)
     * 3 --> 2 (val border is 2)
     * code in photo on 2 july 24 DCMI
     */
    public static int longestConsecutiveSequenceV3(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = a.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int ls = 0, rs = 0;

        }

        return 0;
    }

    //x would be starting number of chunk only iff x-1 is not in array
    public static int longestConsecutiveSequenceV2(int[] a) {
        Set<Integer> numSet = new HashSet<>();
        int ans = 0;
        for (int num : a) {
            numSet.add(num);
        }

        for (int num : a) {
            if (!numSet.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                ans = Math.max(ans, currentStreak);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {10, 3, 7, 9, 5, 4, 16, 20, 6, 5, 19};
        int[] a1 = {7, 6, 5, 5, 3, 4};
        int[] a2 = {0,3,7,2,5,8,4,6,0,1};
        int[] a3 = {0, -1};
        int[] a4 = {1,2,0,1};
        int eleInConsecutiveOrder = longestConsecutiveSequenceV2(a4);
        System.out.println("Longest Len of  Consecutive :: " + eleInConsecutiveOrder);
    }

}
