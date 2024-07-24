package com.rotatingmind.backtracking;

import java.util.ArrayList;
import java.util.List;

record Pair(int x, int y) {}

public class RatMazePath {

     public static void path(List<List<Pair>> res, List<Pair> paths, int[][] mat, int i, int j) {
         int n = mat.length;
         Pair p = new Pair(i, j);
         paths.add(p);
         int size = paths.size();

         // Check if current cell is invalid or blocked
         if (i >= mat.length || j >= mat[0].length || mat[i][j] == 1) {
             paths.remove(size-1);
             return;
         }

         // Check if reached destination
         if (i == mat.length-1 && j == mat[0].length-1) {
             res.add(new ArrayList<>(paths));
             paths.remove(size-1);
             return;
         }

         // Move down
         path(res, paths, mat, i+1, j);

         // Move right
         path(res, paths, mat, i, j+1);

         // Remove current cell from path
         paths.remove(p);

     }


    public static void main(String[] args) {
         int[][] a = {
                 {0, 0, 1, 1},
                 {0, 0, 1, 0},
                 {1, 0, 1, 1},
                 {0, 0, 0, 0},
         };
        List<List<Pair>> possiblePath = new ArrayList<>();
        path(possiblePath, new ArrayList<>(), a, 0, 0);

        possiblePath.forEach(path -> {
            System.out.println(path);
        });
    }
}
