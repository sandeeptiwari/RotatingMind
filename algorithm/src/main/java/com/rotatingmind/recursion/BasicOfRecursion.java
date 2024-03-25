package com.rotatingmind.recursion;

/**
 *
 */
public class BasicOfRecursion {

    public static void func(int x) {
        System.out.println(x);

        if (x >= 3) {
            return;
        }

        func(x+1  );
        func(x+2);
    }


    //print n natural number

    public static void printNum(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        printNum(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printNum(20);
    }
}
