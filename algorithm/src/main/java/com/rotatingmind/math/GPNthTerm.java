package com.rotatingmind.math;

public class GPNthTerm {

    public static void main(String[] args) {
        GPNthTerm obj = new GPNthTerm();
        System.out.println(obj.termOfGP(84, 87, 3));
        System.out.println(obj.termOfGP(73, 37, 2));
    }

    public double termOfGP(int A,int B,int N)
    {
        double r = B/(double)A;
        if (N==1) {
            return A;
        } else if (N==2) {
            return B;
        } else {
            return ( A * (Math.pow(r, N - 1)));
        }
    }
}
