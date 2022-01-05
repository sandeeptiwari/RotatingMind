package com.rottaingmind.ds.recursion;

public class SumOfDigit {

    public static void main(String[] args) {
        SumOfDigit obj = new SumOfDigit();
        int sum = obj.sum(253);
        System.out.println("Sum of digit " + sum);
    }


    private int sum(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + sum(n/10);
    }
}
