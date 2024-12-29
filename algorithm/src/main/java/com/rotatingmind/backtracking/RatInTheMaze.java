package com.rotatingmind.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Rat in the maze
 * We all have might have played the game called Maze in our childhood.A maze is a path or collection of paths,
 * typically from an entrance to a goal. Here,a rat placed at $(0, 0)$ in a square matrix $m[][]$ of order n and has to
 * reach the destination at $(n-1, n-1)$. Your task is to display a sorted array of strings denoting all the possible
 * directions which the rat can take to reach the destination at (n-1, n-1). The directions in which the rat can move are
 * $'U'$(up), $'D'$(down), $'L'$ (left), $'R'$ (right).
 *
 *
 * Input
 * The first line of input contains an integer T denoting the no of test cases.
 * Then T test cases follow. Each test case contains two lines.
 * The first line contains an integer n denoting the size of the square matrix.
 * The next line contains n*n space separated values of the matrix m where 0's represents blocked paths and 1 represent valid paths.
 *
 *
 *
 * Sample Input
 * 2
 * 4
 * 1 0 0 0 1 1 0 1 0 1 0 0 0 1 1 1
 * 4
 * 1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1
 *
 * Sample Output
 * DRDDRR
 * DDRDRR DRDDRR
 */
public class RatInTheMaze {

    static boolean[][] isVisited;


    private static boolean isSafe(int[][] grid, boolean[][] isVisited, int n, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >=n || isVisited[i][j] || grid[i][j] == 0){
            return false;
        }

        return true;
    }

    private static void generateAllPaths(int[][] grid, int n, int i, int j, List<String> res, List<Character> temp) {

        if (!isSafe(grid, isVisited, n, i, j)) {
            return;
        }

        if(i == (n-1)  && j == (n-1)){
            StringBuffer sb = new StringBuffer();
            for(Character c : temp){
                sb.append(c);
            }

            res.add(sb.toString());
            return;
        }
        isVisited[i][j] = true;

        temp.add('D');
        generateAllPaths(grid, n, i+1, j, res, temp);
        temp.remove(temp.size() - 1);

        temp.add('L');
        generateAllPaths(grid, n, i, j-1, res, temp);
        temp.remove(temp.size() - 1);

        temp.add('R');
        generateAllPaths(grid, n, i, j+1, res, temp);
        temp.remove(temp.size() - 1);

        temp.add('U');
        generateAllPaths(grid, n, i-1, j, res, temp);
        temp.remove(temp.size() - 1);

        isVisited[i][j] = false;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();

            int[][] grid = new int[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    grid[i][j] = sc.nextInt();
                }
            }

            List<String> res = new ArrayList<>();

            isVisited = new boolean[n][n];

            generateAllPaths(grid, n, 0, 0, res, new ArrayList<>());

            //Collections.sort(res);

            for(String path : res){
                System.out.print(path + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;

        FastScanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }

        void close(){
            try{
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


}
