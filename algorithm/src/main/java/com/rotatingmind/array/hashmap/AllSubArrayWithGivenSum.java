package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class AllSubArrayWithGivenSum {

    public static int countSubArray(int[] a, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        int preSum = 0;
        mp.put(preSum, 1);

        for (int i = 0; i < a.length; i++) {
            preSum += a[i];

            if (mp.containsKey(preSum - k)) {
                cnt += mp.get(preSum - k);
            }
            mp.put(preSum, mp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1};
        System.out.println(countSubArray(a, 2));
    }

}
