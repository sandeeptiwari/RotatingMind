package com.rotatingmind.twod_array;

/*8
Write an efficient algorithm that searches for a value target in an n x m integer matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

First line of input contains two space-separated integers n and m,denoting size of matrix
Next n lines contain m space-separated integers, mat[i][j]
Next line of input contains a single integer target

Output
Print "true" if you can find the element in the matrix otherwise "false" (without quotes)

Sample input::
3 4
1 3 5 7
10 11 16 20
23 30 34 60
3

123
456
789
 */
public class SearchInMatrix {

    public static boolean search(int[][] a, int target) {

        for (int i = 0; i < a.length; i++) {
            if (isFind(a[i], target)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isFind(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            if (a[mid] == target) {
                return true;
            } else if (target < a[mid]) {
                high = mid - 1;
            } else if (target > a[mid]) {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        boolean find = search(a, 3);

        System.out.println(find);
    }
}
