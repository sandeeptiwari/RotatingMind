package com.rotatingmind.array;

/**
 * Given an integer N, the task is to find the number of ways to represent this number as a sum of 2 or
 * more consecutive natural numbers.
 * nput: N = 15
 * Output: 3
 * Explanation:
 * 15 can be represented as:
 *
 *
 * 1 + 2 + 3 + 4 + 5
 * 4 + 5 + 6
 * 7 + 8
 * Input: N = 10
 * Output: 1
 *
 * 21 = [1, 2 ,3, 4, 5, 5, 6], [6, 7, 8], [10, 11]
 *
 * i <= n * (n + 1) / 2
 *
 * S = a+(a+1)+(a+2)+ … +(a+l−1)
 * S= l/2×(2a+l−1)
 * We need S to be equal to num:
 *  l/2×(2a+l−1) = n
 * l×(2a+l−1) = 2 x n
 * (2a+l−1) = 2 x n / l
 * a = (n - (l * (l + 1) / 2)) % l
 */
public class ConsecutiveSum {


    public static int consecutiveSum(int n) {
        int cnt = 0;
        // Iterate over possible lengths of the sequence
        for (int l = 1; l * (l + 1) / 2 <= n; l++) {
            // Calculate the starting number a
            if ((n - (l * (l + 1) / 2)) % l == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    //1, 2, 3, 4, 5,6, 7, 8, 9, 10, 11, 12, 13, 14, 15
    public static int consecutiveSumV1(int n) {
        int cnt = 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += j;
                if (sum == n) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }


    //1, 2, 3, 4, 5,6, 7, 8, 9, 10, 11, 12, 13, 14, 15
    public static int consecutiveSumV2ByPrefixSum(int n) {
        int cnt = 0;
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + i;
        }

        // Check each prefix sum and use binary search to find the required difference
        for (int i = 0; i <= n; i++) {
            int target = prefixSum[i] - n;
            if (isFound(target, 0, i, prefixSum) >= 0) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int isFound(int ele, int start, int end, int[] prefixSum) {
        int l = start, h = end;

        while (l <= h) {
             int mid = (l + h) / 2;
            if (prefixSum[mid] == ele) {
                return  mid;
            } else if (ele < prefixSum[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        System.out.println(consecutiveSumV2ByPrefixSum(5));
    }

}
