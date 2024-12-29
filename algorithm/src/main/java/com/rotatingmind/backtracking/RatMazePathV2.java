package com.rotatingmind.backtracking;

public class RatMazePathV2 {

    public static void main(String[] args) {

        int[][] arr = {{0, 1, 0}, {0, 0, 0}, {0, 2, -1}};

        int[][] a = {{1,0,0,0}, {0,0,0,0},{0,0,2,-1}};

        System.out.println(new RatMazePathV2().uniquePaths(a));



        RatMazePathV2 obj = new RatMazePathV2();
        System.out.println("count ==>" + obj.uniquePathsIII(a));

    }

    //---leed code -------------
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startX = 0, startY = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        boolean[][] visited = new boolean[m][n];

        return cp1(grid, startX, startY, visited);
    }


    private int cp1(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] == 2) {

            if(isValid(visited, grid) && grid[i][j] != -1) {
                visited[i][j] = false;
                return 1;
            }
            visited[i][j] = false;
            return 0;
        }

        visited[i][j] = true;
        int sum = 0;
        //RIGHT
        if (isSafe1(grid, i, j+1) && !visited[i][j+1]) {
            sum+=cp1(grid, i, j + 1, visited);
        }
        //LEFT
        if (isSafe1(grid, i, j - 1) && !visited[i][j - 1]) {
            sum+=cp1(grid, i, j - 1, visited);
        }
        if (isSafe1(grid, i + 1, j) && !visited[i + 1][j]) {
            sum+=cp1(grid, i + 1, j, visited);
        }
        if (isSafe1(grid, i-1, j) && !visited[i-1][j]) {
            sum+=cp1(grid, i-1, j, visited);
        }
        visited[i][j] = false;
        return sum;
    }

    private boolean isSafe1(int[][] grid, int i, int j) {

        if (i > 0 && j > 0 && i < grid.length && j < grid[0].length && grid[i][j] != -1) {
            return true;
        }

        return false;
    }

    boolean isValid(boolean[][] visited, int[][] grid) {

        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                if(grid[i][j] == 0) {
                    if(!visited[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }













    public int uniquePaths(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int x = 0;
        int y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        return cp(grid, x, y, visited);
    }


    public int cp(int[][] a, int i, int j, boolean[][] visited) {

        if (a[i][j] == 2) return 1; // at termination point at destination

        visited[i][j] = true;
        int sum = 0;

        if (isSafe(a, i, j + 1) && !visited[i][j + 1]) {
            sum += cp(a, i, j + 1, visited);
        }
        if (isSafe(a, i, j - 1) && !visited[i][j - 1]) {
            sum += cp(a, i, j - 1, visited);
        }
        if (isSafe(a, i + 1, j) && !visited[i + 1][j]) {
            sum += cp(a, i + 1, j, visited);
        }
        if (isSafe(a, i - 1, j) && !visited[i - 1][j]) {
            sum += cp(a, i - 1, j, visited);
        }
        visited[i][j] = false;
        return sum;
    }


    public boolean isSafe(int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != -1) {
            return true;
        }
        return false;
    }


}
