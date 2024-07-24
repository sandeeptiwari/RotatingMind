package com.rotatingmind.recursion;


/**
 * Mary has just graduated from one well-known University and is now attending celebration party. Students like to dream
 * of a beautiful life, so they used champagne glasses to construct a small pyramid. The height of the pyramid is n.
 * The top level consists of only 1 glass, that stands on 2 glasses on the second level (counting from the top), then 3 glasses
 * on the third level and so on.The bottom level consists of n glasses.
 *
 * Vlad has seen in the movies many times how the champagne beautifully flows from top levels to bottom ones, filling all
 * the glasses simultaneously. So he took a bottle and started to pour it in the glass located at the top of the pyramid.
 *
 * Each second, Vlad pours to the top glass the amount of champagne equal to the size of exactly one glass. If the glass
 * is already full, but there is some champagne flowing in it, then it pours over the edge of the glass and is equally distributed over two
 * glasses standing under. If the overflowed glass is at the bottom level, then the champagne pours on the table. For the purpose of
 * this problem we consider that champagne is distributed among pyramid glasses immediately. Vlad is interested in the number of completely full
 * glasses if he stops pouring champagne in t seconds.
 *
 * Pictures below illustrate the pyramid consisting of three levels.
 *///https://dev.to/dsasse07/algorithm-practice-champagne-tower-explanation-414h
public class PyramidOfGlasses {


    public static void fill(int index, float[] arr, int level, float volume) {
        if (index >= arr.length || volume == 0) return;
        arr[index] += volume;
        if (arr[index] < 1) {
            return;
        }
        volume = arr[index] - 1;
        arr[index] = 1;
        int left = level + index;
        int right = left + 1;
        fill(left, arr, level + 1, volume / 2.0F);
        fill(right, arr, level + 1, volume / 2.0F);
    }

    public int champagneTower(int poured, int row, int col) {
        if (row == 0) { // Base case: top level (only 1 glass)
            return poured <= 1 ? poured : 1;
        }

        int overflow = Math.max(0, champagneTower(poured - 1, row - 1, col) - 1);
        int leftGlass = Math.min(1, overflow / 2 + champagneTower(overflow / 2, row - 1, col - 1));
        int rightGlass = Math.min(1, overflow / 2 + champagneTower(overflow / 2, row - 1, col));

        return leftGlass + rightGlass;
    }

    public static void main(String[] args) {
        int height = 3;
        int t = 5;
        int length = (height * (height + 1)) / 2;
        float[] arr = new float[length];
        fill(0, arr, 1, t * 1.0F);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) count++;
        }
        System.out.println(count);
    }


   /* public static void main(String[] args) {
        int n = 3;
        int ans = 1;
        System.out.println("1");
        for (int i = 1; i < n; i++) {
            ans *= (n - i);
            ans = ans / i;
            System.out.println(ans);
        }
    }*/
}
