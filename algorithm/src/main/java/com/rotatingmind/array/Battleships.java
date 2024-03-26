package com.rotatingmind.array;

public class Battleships {


    public static int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && (isAdjustEmpty(board, i, j) || !isSameShip(board, i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSameShip(char[][] board, int i, int j) {
        boolean isSame = false;

        return false;
    }

    private static boolean isAdjustEmpty(char[][] board, int i, int j) {
        int left = -1, top = -1, right = -1, bottom = -1;
        boolean isEmpty = false;

        if (j != 0) {
            left = j - 1;
        }
        if (i != 0) {
            top = i - 1;
        }
        if (j != board[0].length - 1) {
            right = j + 1;
        }
        if (i != board.length - 1) {
            bottom = i + 1;
        }

        if (left != -1 && board[i][left] == '.') {
            isEmpty = true;
        }else {
            isEmpty = false;
        }
        if (top != -1 && board[top][j] == '.') {
            isEmpty = true;
        }else {
            isEmpty = false;
        }
        if (right != -1 && board[i][right] == '.') {
            isEmpty = true;
        }else {
            isEmpty = false;
        }
        if (bottom != -1 && board[bottom][j] == '.') {
            isEmpty = true;
        } else {
            isEmpty = false;
        }

        return isEmpty;
    }

    public static void main(String[] args) {
        char[][] input = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        int i = countBattleships(input);
        System.out.println(i);
    }

}
