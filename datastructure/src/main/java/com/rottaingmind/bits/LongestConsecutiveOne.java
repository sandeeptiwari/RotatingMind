package com.rottaingmind.bits;

public class LongestConsecutiveOne {

    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(222));
    }

    public static int maxConsecutiveOnes(int N) {
        int count = 0;
        int max = 0;

        while (N > 0) {
            int temp = (N & 1);
            N = N >> 1;

            if ((N & 1) == temp && temp == 1) {
                count++;
            } else {
                count = 0;
            }

            if (max < count) {
                max = count;
            }
        }

        return max + 1;
    }
}
