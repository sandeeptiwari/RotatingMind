package com.rotatingmind.array;

import java.util.HashMap;
import java.util.Map;

public class Practice {


    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(arr, target);
    }

    private static int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }
            map.put(arr[i], i);
        }
        return result;
    }
}
