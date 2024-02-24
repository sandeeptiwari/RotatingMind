package com.rotatingmind.array.precompute;

public class FetchSumOfSubArrayByStartEndIndex {
    int[] arr = {1, 4, 6, 2, 9, 10, 7};
    int[] prefSum = new int[7];


    public int sumOfSubArray(int i, int j) {
      return prefSum[j] - prefSum[i -1];
    }


    public static void main(String[] args) {
        FetchSumOfSubArrayByStartEndIndex obj = new FetchSumOfSubArrayByStartEndIndex();
        obj.prefSum[0] = obj.arr[0];
        int len = obj.arr.length;

        for (int i = 1; i < len; i++) {
            obj.prefSum[i] = obj.prefSum[i - 1] + obj.prefSum[i];
        }
    }


}
