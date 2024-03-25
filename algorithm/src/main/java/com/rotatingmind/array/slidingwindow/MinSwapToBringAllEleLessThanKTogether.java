package com.rotatingmind.array.slidingwindow;

public class MinSwapToBringAllEleLessThanKTogether {


    /**
     * a = {2, 1, 5, 6, 3}
     * k = 3
     * a1 = {2, 7, 9, 5, 8, 7, 4}, ans - 2, k = 5
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 3};
        collateTogether(a, 3);
    }

    private static void extracted() {
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

    public static void collateTogether(int[] a, int k) {
        int n = a.length;
        int window = 0;
        int greaterElements = 0;

        for(int i = 0; i < n; i++) {
            if (a[i] <= k) {
                window++;
            }
        }

        //Count for the first Window
        //Number of Greater Elements in a Window
        for(int i = 0; i < window; i++) {
            if (a[i] > k) {
                greaterElements++;
            }
        }

        int maxGreaterElements = greaterElements;

        for(int i = window; i <= n - window; i++) {

            if(a[i - window] > k) {
                greaterElements--;
            }

            if(a[i] > k) {
                greaterElements++;
            }

            maxGreaterElements = Math.min(greaterElements, maxGreaterElements);
        }

        System.out.println(maxGreaterElements);
    }
}
