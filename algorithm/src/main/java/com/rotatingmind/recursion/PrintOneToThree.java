package com.rotatingmind.recursion;

public class PrintOneToThree {


    public static void main(String[] args) {
        print(3);
    }

    public static void print(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print(n-1);
        System.out.println(n);
    }
}
