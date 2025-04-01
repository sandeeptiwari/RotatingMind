package com.rotatingmind.array.sorting;

/**
 * You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is defined as follows:
 *
 * (startx, starty): The bottom-left corner of the rectangle.
 * (endx, endy): The top-right corner of the rectangle.
 * Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:
 *
 * Each of the three resulting sections formed by the cuts contains at least one rectangle.
 * Every rectangle belongs to exactly one section.
 * Return true if such cuts can be made; otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
 *
 * Output: true
 *
 * Approach:
 * 1. x-axis: merge interval at x axis -> X
 * 2. y-axis: merge interval at y axis -> Y
 * 3. X.size >= 3 || Y.size >= 3
 *
 * Always sort interval base problem first
 *
 * start = min(star1, start2)
 * end = max (end1, end2)
 */
public class CheckIfGridCanBeCutIntoSectionMergeINterval3394 {

    public boolean checkValidCuts(int n, int[][] rectangles) {
      return true;
    }

    public static void main(String[] args) {
        CheckIfGridCanBeCutIntoSectionMergeINterval3394 checker = new CheckIfGridCanBeCutIntoSectionMergeINterval3394();
        int[][] grid1 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(checker.checkValidCuts(grid1.length, grid1)); // true

        int[][] grid2 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        System.out.println(checker.checkValidCuts(grid2.length, grid2)); // false
    }
}
