package com.rottaingmind.ds.dp.practice;

public class RodCuttingProblemCh7 {


    private int maxVal(int[] price) {
        return maxVal(0, price);
    }

    private int maxVal(int i, int[] price) {
        if (i == 0) return 0;

        int ans = 0;
        for (int j = 1; j <= i; j++) { // We can cut rods from 1 to i
            ans = Math.max(ans, price[j - 1] + maxVal(i - j, price));
        }

        return ans;
    }

    public static void main(String[] args) {
        RodCuttingProblemCh7 solver = new RodCuttingProblemCh7();

        int[] price1 = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Test Case 1: " + solver.maxVal(8, price1)); // Expected: 22

        int[] price2 = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Test Case 2: " + solver.maxVal(8, price2)); // Expected: 24

        int[] price3 = {2, 5, 7, 8};
        System.out.println("Test Case 3: " + solver.maxVal(4, price3)); // Expected: 10

        int[] price4 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Test Case 4: " + solver.maxVal(8, price4)); // Expected: 8

        int[] price5 = {5, 10, 13, 17, 20, 25};
        System.out.println("Test Case 5: " + solver.maxVal(6, price5)); // Expected: 30
    }
}
