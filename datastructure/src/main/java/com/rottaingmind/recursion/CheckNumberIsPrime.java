package com.rottaingmind.recursion;

public class CheckNumberIsPrime {

    public static boolean isPrime(int num, int i) {
        if (num == i) return true;

        else if (num % i == 0) return false;

        return isPrime(num, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(10             , 2));
    }
}
