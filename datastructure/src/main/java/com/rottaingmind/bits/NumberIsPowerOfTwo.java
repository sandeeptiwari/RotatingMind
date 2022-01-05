package com.rottaingmind.bits;

public class NumberIsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowOfTwo(2));
    }

    public static boolean isPowOfTwo(int n) {
       if (n == 0 || (n & 1) != 0) {
           return false;
       }
       if (n == 2 || n == 1) {
           return true;
       }

       return isPowOfTwo(n/2);
    }
}
