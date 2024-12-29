package com.rotatingmind.array.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Mishka has got n empty boxes. For every i (1 ≤ i ≤ n), i-th box is a cube with side length ai.
 *
 * Mishka can put a box i into another box j if the following conditions are met:
 *
 * i-th box is not put into another box;
 * j-th box doesn't contain any other boxes;
 * box i is smaller than box j (ai < aj).
 * Mishka can put boxes into each other an arbitrary number of times. He wants to minimize the number of visible boxes. A box is called visible iff it is not put into some another box.
 *
 * Help Mishka to determine the minimum possible number of visible boxes!
 *
 * Input
 * The first line contains one integer n (1 ≤ n ≤ 5000) — the number of boxes Mishka has got.
 *
 * The second line contains n integers a1, a2, ..., an (1 ≤ ai ≤ 109), where ai is the side length of i-th box.
 *
 * Output
 * Print the minimum possible number of visible boxes.
 *
 * Examples
 * inputCopy
 * 3
 * 1 2 3
 * outputCopy
 * 1
 * inputCopy
 * 4
 * 4 2 4 3
 * outputCopy
 * 2
 *
 * Approach:
 * Approach: Add all elements with their frequency in hashmap.
 *
 * Iterate over hashmap
 *
 * case 1: all elements distinct, frequency of largest element is answer
 *
 * case 2: duplicates exist, element with highest frequency, that frequency is answer.
 *
 * Is this correct.
 *
 * e.g: [1,2,3]===1
 *
 * [4,2,4,3] -->{4:2,   2:1,    3:1}==2 is answer
 */
public class BoxesPacking {

    public static int getVisibleBoxes(int[] boxes) {
        int n = boxes.length;
        Map<Integer, Integer> frequencyByBox = new HashMap<>();

        for (int i = 0; i < n; i++) {
            frequencyByBox.merge(boxes[i], 1, Integer::sum);
        }

        return frequencyByBox.entrySet()
                .stream().max(Map.Entry.comparingByKey()).map(Map.Entry::getValue).orElse(0);
    }

    public static void main(String[] args) {
        //int[] a = {1, 2, 3};
        int[] a = {4,2,4,3};
        System.out.println(getVisibleBoxes(a));
    }
}
