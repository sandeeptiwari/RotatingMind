package com.rottaingmind.ds.queue.pp;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * +ve number natural numbers whose digit are belongs {1, 2, 3}
 * print in sorted form
 * -> 11231 Y
 * -> 3 Y
 * -> 14 3 1 N
 *
 * N = 10
 *  -> 1
 *  -> 2
 *  -> 3
 *  -> 11
 *  -> 12
 *  -> 13
 *  -> 21
 *  -> 22
 *  -> 23
 *  -> 31
 *
 *  lets say num is belongs to this family then
 *  num + 1 (concat not plus)
 *  num + 2
 *  num + 3
 *  must belongs to this family
 *  e.g
 *  3132
 *   -> with 1 => 31321
 *   -> with 2 => 31322
 *   -> with 3 => 31323
 */
public class LevelOrderTraversalInQueue {

    private static Queue<Integer> q = new ArrayDeque<Integer>();

    public static void print123Family(int n) {
        q.add(0);
        int cnt = 0;

        while (!q.isEmpty() && cnt < n) {

            int parent = q.poll();
            if (parent != 0) {
                System.out.print(parent + ", ");
                cnt++;
            }

            int child1 = parent * 10 + 1;
            q.add(child1);
            int child2 = parent * 10 + 2;
            q.add(child2);
            int child3 = parent * 10 + 3;
            q.add(child3);
        }
    }

    public static void main(String[] args) {
        print123Family(10);
    }

}
