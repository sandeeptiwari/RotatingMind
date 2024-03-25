package com.rotatingmind.array;


/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class MaxContainerArea {


    public int maxAreaV2(int[] height) {

        int len = height.length;
        int result = 0;
        int maxArea = Integer.MIN_VALUE;
        int l = 0;
        int r = len - 1;

        while (l < r) {
            result = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(result, maxArea);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
     return maxArea;
    }

    public int maxArea(int[] height) {
        int len = height.length;
        int result = 0;
        int area = 0;

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {

                area = Math.min(height[i], height[j]) * (j - i);
                result = Math.max(result, area);

            }

        }

        return result;
    }

    public int maxAreaV1(int[] height) {
        int len = height.length;
        int result = 0;
        int maxArea = Integer.MIN_VALUE;
        int l = 0;
        int r = len - 1;

        while (l < r) {
            result = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, result);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }




    public static void main(String[] args) {
        MaxContainerArea maxContainerArea = new MaxContainerArea();
        //int[] heights = {1,8,6,2,5,4,8,3,7};
        int[] heights = {1,8,6,2,5,4,8,3,};
        System.out.println(maxContainerArea.maxAreaV2(heights));
    }
}
