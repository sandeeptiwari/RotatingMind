package com.rotatingmind.array;

/**
 * There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 *
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 *
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 *
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 *
 * You are given a string dominoes representing the initial state where:
 *
 * dominoes[i] = 'L', if the ith domino has been pushed to the left,
 * dominoes[i] = 'R', if the ith domino has been pushed to the right, and
 * dominoes[i] = '.', if the ith domino has not been pushed.
 * Return a string representing the final state.
 *
 *
 *
 * Example 1:
 *
 * Input: dominoes = "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 */
public class PushDominoes838 {
    /**
     * Intuition
     * Dominoes fall to the right (R) or to the left (L) and exert forces on neighboring upright dominoes.
     * To determine their final state, simulate the forces from both directions.
     *
     * Approach
     * Traverse left to right:
     * Add positive force (n) when you encounter 'R'.
     * Decrease force by 1 for every next '.', until 0.
     * Reset to 0 when 'L' is encountered.
     *
     * Traverse right to left:
     * Add negative force (-n) when you encounter 'L'.
     * Increase force by 1 for every next '.', until 0.
     * Reset to 0 when 'R' is encountered.
     *
     * Combine both force arrays:
     * If net force is 0 → '.'
     * If net force is positive → 'R'
     * If net force is negative → 'L'
     * Complexity
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];
        int force = 0;

        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = n;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] = force;
        }

        force = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = n;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (forces[i] == 0) {
                result.append(".");
            } else if (forces[i] > 0) {
                result.append("R");
            } else {
                result.append("L");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        PushDominoes838 obj = new PushDominoes838();
        String s = "..R..L..";

        System.out.println(obj.pushDominoes(s));//..RRLL..
    }
}
