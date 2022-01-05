package com.rotatingmind.math;

public class FindAllDivisorsOfANumber {

    public static void main(String[] args) {
        FindAllDivisorsOfANumber obj = new FindAllDivisorsOfANumber();
        obj.printAllDivisors(30);
    }

    public void printAllDivisors(int num) {

        for (int i = 1; i * i < num; i++) {
            if(num % i == 0) {
                System.out.println(i);
                if (num != i) {
                    System.out.println(num / i);
                }
            }
        }
    }
}
