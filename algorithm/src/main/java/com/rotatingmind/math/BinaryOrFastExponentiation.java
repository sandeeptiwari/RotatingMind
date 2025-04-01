package com.rotatingmind.math;

public class BinaryOrFastExponentiation {

    /**
     *  T. C. =
     */
   public long findPower(int a, int b) {

       if (b == 0) return 1;

       long val = findPower(a, b / 2);

       long result = val * val;

       if (b % 2 == 1) {
           result *= a;
       }

       return result;
    }
}
