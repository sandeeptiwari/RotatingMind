package com.rottaingmind.ds.queue.pp;

import java.util.ArrayDeque;
import java.util.Queue;

public class DesignStackUsingQueue {

    private Queue<Integer> q = new ArrayDeque<Integer>();
    private Queue<Integer> tmpQ = new ArrayDeque<Integer>();

    public void push(int x) {
        q.offer(x);
    }

    public int pop() {
        while (!q.isEmpty()) {
            tmpQ.offer(q.poll());
        }
        int ans = tmpQ.poll();
        q = tmpQ;
        return ans;
    }

    public int peek() {
        return q.peek();
    }
}
