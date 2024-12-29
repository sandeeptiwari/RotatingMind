package com.rotatingmind.backtracking;

public class NQueenProblems {

    int[][] a = new int[4][4];

    // r = 0 1st time
    private void printNQueen(int row, boolean isAnswerFound) {
        int n = a.length;
        if (row == n) {
            isAnswerFound = true;
            System.out.println("print array a here");
        }

        if (isAnswerFound) {
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {
                a[row][col] = 1;
                printNQueen(row, isAnswerFound);
                a[row][col] = 0;
            }
        }
    }

    private boolean isSafe(int row, int col) {
        int x = row -1;

        while (x >= 0) {
            if (a[x][col] == 1) {
                return false;
            }
            x--;
        }
        x = row -1;
        int y = col -1;

        while (x >= 0 && y >= 0) {
            if (a[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }

        x = row -1;
        y = col -1;

        while (x >= 0 && y < a.length) {
            if (a[x][y] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
