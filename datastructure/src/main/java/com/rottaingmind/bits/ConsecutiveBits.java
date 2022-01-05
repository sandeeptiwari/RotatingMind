package com.rottaingmind.bits;

public class ConsecutiveBits {

    public static void main(String[] args) {
        System.out.println(isSparse(41));
    }

    public static boolean isSparse1(int n) {
        boolean isConsecutive = false;
        int pos = 0, prev = 0;

        while (n > 0) {

            if ((n & 1) == 1) {

                if ((pos - prev == 1)) {
                    isConsecutive = false;
                    break;
                }
                isConsecutive = true;
                prev = pos;
                pos++;
            } else {
                pos = prev = 0;
            }

            n = n >> 1;
        }

        return isConsecutive;
    }

    public static boolean isSparse(int n) {
        int temp;

        while (n > 0) {
            temp = n & 1;
            n = n >> 1;
            if (temp == (n & 1) && temp == 1)
                return false;

        }
        return true;
    }
}
