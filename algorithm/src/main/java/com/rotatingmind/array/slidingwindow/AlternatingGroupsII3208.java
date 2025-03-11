package com.rotatingmind.array.slidingwindow;

/**
 * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
 *
 * colors[i] == 0 means that tile i is red.
 * colors[i] == 1 means that tile i is blue.
 * An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
 *
 * Return the number of alternating groups.
 *
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 */
public class AlternatingGroupsII3208 {

    /**
     * Input: colors = [0,1,0,1,0], k = 3
     *
     * Output: 3
     *
     * 🔍 Understanding the Problem
     * In the Alternating Groups II problem:
     *
     * ✅ Each element in the window of size k must alternate in pattern — not just adjacent elements.
     * ✅ Example alternating patterns could be [1, 2, 1], [2, 1, 2], etc.
     * ✅ We need to check the entire window for the alternating pattern — not just adjacent elements.
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] temp = new int[n + k - 1];
        System.arraycopy(colors, 0, temp, 0, n);
        System.arraycopy(colors, 0, temp, n, k - 1);

        int count = 0;
        int left = 0;

        for (int right = 0; right < temp.length; right++) {
            if (right > 0 && temp[right] == temp[right - 1]) {
                left = right;
            }

            if (right - left + 1 >= k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        AlternatingGroupsII3208 obj = new AlternatingGroupsII3208();
        int res = obj.numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3);
        int res1 = obj.numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1}, 6);
        int res2 = obj.numberOfAlternatingGroups(new int[]{1,1,0,1}, 4); //0

        System.out.println("Result :: " + res);
        System.out.println("Result :: " + res1);
        System.out.println("Result :: " + res2);
    }
}
