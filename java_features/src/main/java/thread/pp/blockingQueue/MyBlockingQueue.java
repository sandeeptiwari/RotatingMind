package thread.pp.blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition condition = reentrantLock.newCondition();
    private final Queue<Integer> q;
    private final int capacity;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.q = new LinkedList<>();
    }

    public int take() throws InterruptedException {
        reentrantLock.lock();
        try {
            while (q.size() == 0) {
                condition.await();
            }

            int val = q.poll();

            if (q.size() == capacity - 1) {
                condition.signalAll();
            }

            return val;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void put(Integer x) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (q.size() == capacity) {
                condition.await();
            }
            q.add(x);

            if (q.size() == 1) {
                condition.signalAll();
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
