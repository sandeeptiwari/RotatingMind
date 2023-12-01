package com.rotatingmind.math;

public class Count1BitsInNumber {

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count += n % 2;
            n = n >> 1 ;
        }
        return count;
    }

    public int hammingWeightV1(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        Count1BitsInNumber count1BitsInNumber = new Count1BitsInNumber();
        System.out.println(count1BitsInNumber.hammingWeight(00000000000000000000000000001011));
    }
}
