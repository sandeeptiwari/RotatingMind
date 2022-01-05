package com.rotatingmind.math;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int num) {
        int rev = 0, n = num;
        while (num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num = num / 10;
        }

        return n == rev;
    }
}
