package com.rottaingmind.bits;

public class FindTheOddAndEven {

    public static void main(String[] args) {
        System.out.println("Result : " + isEven(10));
    }

    public static boolean isEven(int number) {
        int result  = number & 1;
        return result == 0 ? true : false;
    }
}
