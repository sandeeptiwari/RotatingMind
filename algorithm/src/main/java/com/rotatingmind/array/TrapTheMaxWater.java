package com.rotatingmind.array;

public class TrapTheMaxWater {

    //1,8,6,2,5,4,8,3,7
    public int maxArea(int[] height) {
        int len = height.length;
        int totalWaterUnit = 0;

        if (len < 3) {
            return 0;
        }

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        for(int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[len - 1] = height[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for(int i = 0; i < len; i++) {
            totalWaterUnit += (Math.min(rightMax[i], leftMax[i]) - height[i]);
        }

        return totalWaterUnit;

    }


    public static void main(String[] args) {
        TrapTheMaxWater trapTheMaxWater = new TrapTheMaxWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(trapTheMaxWater.maxArea(height));
    }
}
