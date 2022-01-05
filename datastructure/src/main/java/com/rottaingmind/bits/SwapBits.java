package com.rottaingmind.bits;

public class SwapBits {

    public static void main(String[] args) {

    }

    public static int swapBits(int n)
    {
        int oddMask = 0x55555555; //odd mask preserve only odd bits
        int evenMask = 0xAAAAAAAA; //even mask preserve only even bits

        //remove all even/odd bits
        int onlyOddBits = n & oddMask;
        int onlyEvenBits = n & evenMask;

        //left shift to onlyEven bits

        onlyEvenBits >>= 1;
        onlyOddBits <<= 1;

        return onlyEvenBits | onlyOddBits;
    }
}
