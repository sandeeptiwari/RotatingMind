package com.rotatingmind.array.slidingwindow;

public class MinimumSwapsToGroupAllOnesTogether {

    public static void main(String[] args) {
        int [] a = {0,1,0,1,1,0,0};

        System.out.println(minSwaps(a));
    }

    public static int minSwaps(int[] nums) {

        int n = nums.length;
        int zeroCount = 0 ;
        int totalOne = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                totalOne++;
            }
        }

        if (n == totalOne || totalOne == 0)
            return 0;

        for (int i = 0; i < totalOne; i++) {
            if( nums[i % n] == 0){
                zeroCount++;
            }
        }

        for( int i = totalOne ; i < 2 * n; i++) {
            if( nums[i % n] == 0){
                zeroCount++;
            }
            if( nums[(i  - totalOne) % n ] == 0){
                zeroCount--;
            }
            min = Math.min(min, zeroCount);
        }

        return min;
    }
}
