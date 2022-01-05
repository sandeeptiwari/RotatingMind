package com.rotatingmind.math;

public class DigitsInFactorial {

    /**
     * digits = log10num + 1
     * @param N
     * @return
     */
    public int digitsInFactorial(int N){
        if (N == 0 || N == 1) {
            return 1;
        }

        float digit = 0;

        for(int i = 2; i <= N; i++) {
            digit += Math.log10(i);
        }
        return (int)digit + 1;
    }
}
