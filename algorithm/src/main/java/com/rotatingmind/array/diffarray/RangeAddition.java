package com.rotatingmind.array.diffarray;

/**
 * You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
 *
 * You have an array arr of length, with all zeros, and you have some operation to apply on arr. In the ith operation,
 * you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
 *
 * Return arr after applying all the updates.
 *
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 */
public class RangeAddition {


    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        int qLen = updates.length;

        for (int i = 0; i < qLen; i++) {
            int startIndex = updates[i][0];
            int endIndex = updates[i][1];
            int value = updates[i][2];

            diff[startIndex] += value;
            if (endIndex + 1 < length) {
                diff[endIndex + 1] -= value;
            }
        }



        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }

    public static void main(String[] args) {
        int [][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int length = 5;

        int[] modifiedArray = getModifiedArray(length, updates);

        for (int i = 0; i < modifiedArray.length; i++) {
            System.out.print(modifiedArray[i] + " ");
        }
    }

}
