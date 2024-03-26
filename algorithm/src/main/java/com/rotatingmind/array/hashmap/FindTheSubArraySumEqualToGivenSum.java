package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FindTheSubArraySumEqualToGivenSum {


    public static int[] findSubArray(int[] a, int sum) {
        int res[] = new int[2];
        int len = a.length;
        int i = 0, j = 0;
        int currSum = a[i];

        while (j < len) {
            if (currSum < sum) {
                j++;
                if (j < len) {
                    currSum += a[j];
                }
            } else if (currSum > sum) {
                currSum -= a[i];
                i++;
                if (i > j) {
                    j++;
                    if (j < len) {
                        currSum = a[j];
                    }
                }
            } else {
                res[0] = i;
                res[1] = j;
                break;
            }
        }
        return res;
    }

    public static void findSubArrayOfGivenSum(int[] a, int sum) {
        int currSum = 0;
        int start = 0;
        int end = -1;
        int n = a.length;

        Map<Integer, Integer> sumByIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            currSum += a[i];

            if (currSum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            if (sumByIndex.containsKey(currSum - sum)) {
                start = sumByIndex.get(currSum-sum) + 1;
                end = i;
                break;
            }
            sumByIndex.put(currSum, i);
        }
        if (end == -1) {
            System.out.println("Not found");
        } else {
            System.out.println(start + " " + end);
        }
    }

    public static int numOfSubArrayEqualToGivenSum(int[] a, int target) {
        int ans = 0, sum = 0;
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += a[i];

            if (map.containsKey(sum - target)) {
                ans += map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 4, 6, 2};
        findSubArrayOfGivenSum(arr, 15);
        //System.out.println(subArray[0]);
        //
        // System.out.println(subArray[1]);
    }
}
