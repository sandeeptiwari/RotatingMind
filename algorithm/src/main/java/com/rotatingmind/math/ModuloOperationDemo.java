package com.rotatingmind.math;

public class ModuloOperationDemo {


    public int getFastPow(int a, int b) {
        int res = 1;

        while (b > 0) {
            if ((b & 1) != 0) {
                res *= a;
            }
            a = a * a;
            b = b >> 1;
        }
        return res;
    }
}
