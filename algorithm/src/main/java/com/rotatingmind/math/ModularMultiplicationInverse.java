package com.rotatingmind.math;

public class ModularMultiplicationInverse {

    public static void main(String[] args) {

    }

    public int modInverse(int a, int m)
    {
        if (gcd(a, m) == 1) {
            return a % m;
        }

        return -1;
    }

    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
