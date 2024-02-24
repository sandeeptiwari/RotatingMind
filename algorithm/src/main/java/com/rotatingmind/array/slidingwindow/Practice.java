package com.rotatingmind.array.slidingwindow;

public class Practice {

    /**
     * a = {2, 1, 5, 6, 3}
     * k = 3
     * a1 = {2, 7, 9, 5, 8, 7, 4}, ans - 2, k = 5
     * @param args
     */
    public  void main1() {
        int totalLegalCount = 0;
        int[] a = {2, 7, 9, 5, 8, 7, 4};
        int n = a.length;
        int k = 5;
        int maxLegalCountInWindow = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] <= k) {
                totalLegalCount += 1;
            }
        }

        int w = totalLegalCount;

        for (int i = 0; i < w; i++) {
            if(a[i] <= k) {
                maxLegalCountInWindow++;
            }
        }

        for (int i = w; i < n-w; i++) {
            if (a[i] <= k) {
                maxLegalCountInWindow++;
            }
            if (a[i-w] <= k) {
                maxLegalCountInWindow--;
            }
        }

        System.out.println(w-maxLegalCountInWindow);

    }


    public static void main(String[] args) {
        int a [] = {1, 2, -1, 0, 4};
        int n = a.length;
        int k = 3;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += a[i];
        }

        System.out.println(sum);

        for (int i = k; i < n; i++) {
            sum += a[i];
            sum -= a[i -k];
            System.out.println(sum);
        }

        System.out.println(sum);
    }
}
