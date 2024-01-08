package thread.pp.blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {

    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();
    private final Queue<Integer> q;

    private final int capacity;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.q = new LinkedList<>();
    }

    public int take() throws InterruptedException {
        reentrantLock.lock();
        while (q.size() == 0) {
            condition.wait();
        }

        int val =  q.poll();

        if (q.size() == capacity) {
            condition.signal();
        }

        reentrantLock.unlock();

        return val;
    }

    public void put(Integer x) throws InterruptedException {
        reentrantLock.lock();
        while(q.size() == capacity) {
            condition.wait();
        }
        q.add(x);
        reentrantLock.unlock();

        if (q.size() == 1) {
            condition.signal();
        }
    }
}
