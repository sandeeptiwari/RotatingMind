package com.rotatingmind.backtracking;

public class RatMazePathV3 {

    public static void main(String[] args) {

        int[][] arr = {{0, 1, 0}, {0, 0, 0}, {0, 2, -1}};

        int[][] a = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};

        //System.out.println(new RatMazePathV3().uniquePaths(a));


        RatMazePathV3 obj = new RatMazePathV3();
        System.out.println("count ==>" + obj.uniquePathsIII(a));

    }
    public int uniquePathsIII(int[][] grid) {

        int row = 0;
        int col = 0;
        int countZeros = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
                if(grid[i][j] == 0) {
                    countZeros++;
                }
            }
        }
        boolean[][] used = new boolean[grid.length][grid[0].length];
        return count(grid, used, row, col, countZeros + 1);
    }

    int count(int[][] grid, boolean[][] used, int row, int col, int countZeros) {

        used[row][col] = true;
        if(grid[row][col] == 2) {
            if(countZeros == 0 && grid[row][col] != -1) {
                used[row][col] = false;
                return 1;
            }
            used[row][col] = false;
            return 0;
        }

        if(grid[row][col] == -1) {
            used[row][col] = false;
            return 0;
        }

        int paths = 0;

        //DOWN
        if(row < grid.length - 1 && !used[row + 1][col]) {
            paths += count(grid, used, row + 1, col, countZeros - 1);
        }
        //RIGHT
        if(col < grid[0].length - 1 && !used[row][col + 1]) {
            paths += count(grid, used, row, col + 1, countZeros - 1);
        }
        //UP
        if(row > 0 && !used[row - 1][col]) {
            paths += count(grid, used, row - 1, col, countZeros - 1);
        }
        //LEFT
        if(col > 0 && !used[row][col - 1]) {
            paths += count(grid, used, row, col - 1, countZeros - 1);
        }

        used[row][col] = false;
        return paths;
    }


}
