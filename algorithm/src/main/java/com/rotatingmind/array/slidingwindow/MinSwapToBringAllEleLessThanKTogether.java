package com.rotatingmind.array.slidingwindow;

public class MinSwapToBringAllEleLessThanKTogether {


    /**
     * a = {2, 1, 5, 6, 3}
     * k = 3
     * a1 = {2, 7, 9, 5, 8, 7, 4}, ans - 2, k = 5
     * @param args
     */
    public static void main(String[] args) {
       int a[] = {2, 5, 7, 9, 8, 7, 4};
       int n = a.length;
       int k = 5;
       int maxLegalCount = 0;
       int totalLegalCount = 0;

        for (int i = 0; i < n; i++) {
            if(a[i] <= k) {
                totalLegalCount++;
            }
        }

        int s = totalLegalCount;

        //check max within window (sizeOfWindow)
        for (int i = 0; i < s; i++) {
            if(a[i] <= k) {
                maxLegalCount++;
            }
        }
        int currMax = maxLegalCount;
        for (int i = s; i <= n-s; i++) {

            if (a[i] <= k) {
                maxLegalCount++;
            }
            if (a[i-s] <= k) {
                maxLegalCount--;
            }
            maxLegalCount = Math.max(currMax, maxLegalCount);
        }

        maxLegalCount = Math.max(currMax, maxLegalCount);

        System.out.println(totalLegalCount-maxLegalCount);
    }
}
