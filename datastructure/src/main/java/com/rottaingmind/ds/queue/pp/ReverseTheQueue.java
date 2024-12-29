package com.rottaingmind.ds.queue.pp;

import java.util.Queue;

public class ReverseTheQueue {
    //user stack and push elements into that stack
    //now push back into queue
    //TC = o(n)

    public void reverseTheQueue(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int x = q.poll();
        reverseTheQueue(q);
        q.add(x);
    }
}
