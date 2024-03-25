package com.rotatingmind.twod_array;

public class SearchEleInMatrixAndReturnIndex {

    /**
     * Each row of matrix is sorted and is column is also sorted
     * @param a
     * @param key
     * @return
     * TC = o(m X n)
     */
    public static int[] search(int[][] a, int key) {
        int n = a.length;
        int m = a[0].length;
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == key) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Binary search technique
     * @param a
     * @param key
     * @return
     *  TC = o(mlongn)
     */
    public static int[] searchV1(int[][] a, int key) {
        int n = a.length;
        int[] res = new int[2];

        for (int i = 0; i < n; i++) {
            int found = bSearch(a[i], key);
            if (found >= 0) {
                res[0] = i;
                res[1] = found;
            }
        }
        return res;
    }

    public static int bSearch(int[] row, int key) {
        int l = 0, h = row.length, mid = -1;

        while (l < h) {
            mid = (l + h) / 2;

            if (row[mid] == key) {
                return mid;
            } else if (key < row[mid]) {
                h = mid - 1;
            } else if (key > row[mid]) {
                l = mid + 1;
            }
        }
        return -1;
    }


    /**
     * Since row is sorted, then start searching from last element of first row, there could be 3 possibility for each ele:
     * 1- key == ele
     * 2- key > ele
     * 3- key < ele
     * case 1.
     * if 1 case fulfills just return the coordinates
     * Case 2.
     * in second case if key greater it means previous element can be discorted for
     * that we can skip that specific row and moved to last element of next row like :
     * int first start point was (0, n-1) now it would be (1, n-1) -> just need to increase i's (means row value)
     *
     * Case3.
     * in This case if key less than ele it means that ele is not present in current colum, we can be discort column.
     * and moved to next ele of previous column :
     * int first start point was (0, n-1) now it would be (1, n-1) -> just need to increase i's (means row value)
     *
     * example
     * @param a
     * @param key
     * @return
     */
    public static int[] searchV2(int[][] a, int key) {
        int m = a.length;
        int n = a[0].length;
        int[] res = {-1, -1};

        int start = a[0][m-1];
        int i = 0, j = n-1;

        while (j >= 0 && i < m-1) {

            if (start == key) {
                res[0] = i;
                res[1] = j;
                break;
            } else if (key < start) {
                start = a[i][--j];
            } else {
                start = a[++i][j];
            }
        }
       return res;
    }


    public static void main(String[] args) {
        int[][] a = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
        };
        //int[] res = search(a, 48);
        //int[] res = searchV1(a, 48);
        int[] res = searchV2(a, 48);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
