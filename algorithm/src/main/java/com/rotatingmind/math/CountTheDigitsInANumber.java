package com.rotatingmind.math;

public class CountTheDigitsInANumber {

    public static void main(String[] args) {
        System.out.println(countDigit(1234));
    }

    public static int numOfDigits(int num) {
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public static int numOfDigitsByIter(int num) {
        if(num == 0) {
            return 0;
        }

        return 1 + numOfDigitsByIter(num / 10);
    }

    public static double countDigit(int num) {
        return  Math.floor(Math.log10(num)) + 1;
    }
}
