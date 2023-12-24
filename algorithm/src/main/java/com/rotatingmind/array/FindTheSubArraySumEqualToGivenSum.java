package com.rotatingmind.array;

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

    public static void main(String[] args) {
        int arr[] = {5, 3, 4, 6, 2};
        int[] subArray = findSubArray(arr, 15);
        System.out.println(subArray[0]);
        System.out.println(subArray[1]);
    }
}
