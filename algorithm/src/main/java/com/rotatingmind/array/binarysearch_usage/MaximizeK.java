package com.rotatingmind.array.binarysearch_usage;

/**
 * we have +ve  integer in an array now need to find max possible k such that non of the subarray of
 * size k has a sum > x
 *
 * [1, 2, 3, 4] , k = 8
 * subarrays = [], [1] subarrau of the size 1 is follow the rule because its >= 8
 *
 * [1, 2] = 1 + 2 < 8 means subarray of size two follow the rule
 *
 * we can calculate  sum of subarray by using sliding window
 */
public class MaximizeK {


    public boolean arrayFollowTheRule() {
      return false;
    }

    public static int maxK(int[] arr, int k, int n){
        int s = 0;
        int e = n;
        while(s <= e){
            int m = s+(e-s)/2;
            if(!isPossible(arr, m, k)){
                e = m-1;
            }else{
                if(!isPossible(arr, m+1, k)) return m;
                else s = m+1;
            }
        }
        return -1;
    }

    public static boolean isPossible(int[] a, int mid, int x) {
        int sum = 0;

        for (int i = 0; i < mid  ; i++) {
            sum += a[i];
        }

        if (sum > x) {
            return false;
        }

        int start = 0;
        int end = mid -1;

        //apply sliding window to calculate sum of all subarray
        while(start < end) {
            sum -= a[start];
            start++;
            end--;
            sum += a[end];
            if (sum > x) {
                return false;
            }
        }
        return true;
    }

}
