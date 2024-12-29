package com.rottaingmind.ds.queue.pp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * print binary representation of all the number from num lie [1...N]
 * hieghest bit = log i base 2 in binary rep
 */
public class BinaryForm {


    /**
     *       10 - Num (1010)
     *       /             \
     *      /               \
     * 10100(20 = 2 * num)    10101 (21 = 2 * num + 1)
     * means left child is left shift 1 unit and right  shift 1 unit
     *
     *   lets say x is the num
     *
     *             x                                    1010
     *            / \                    =               /\
     *          /    \                                  /  \
     *      x * 10  x * 10 + 1                       10100  10101
     */
    public void printAllBinaryRepTillInputNum(int num) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        int cnt = 0;

        while (!q.isEmpty() && cnt < num) {
            int v = q.poll();
            System.out.println(v + ", ");

            q.add(v * 10);
            q.add(v * 10 + 1);
            cnt++;
        }
    }
}
