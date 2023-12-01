package com.rotatingmind.twod_array;

public class PatterOne {
    
    public static void printFiveBasedPattern() {
        int n = 5;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 9; j++) {
                if (j < (n - 1 - i))  {
                    System.out.print("_");
                } else if (j >= (9 - i)) {
                    System.out.print("0");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        printFiveBasedPattern();
    }
}
