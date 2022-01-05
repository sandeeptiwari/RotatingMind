package com.rotatingmind.math;

public class LCMTest {

    public int lcm(int a, int b) {
        if(a == 0 && b == 0) {
            return 0;
        }
        return Math.abs(a*b) / gcd(a, b);
    }

    public int lcmV2(int a, int b) {
        int result = Math.max(a, b);

        while (true) {
            if(result % a == 0 && result % b == 0) {
                return result;
            }
            result++;
        }
    }

    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
