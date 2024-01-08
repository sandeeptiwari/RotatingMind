package thread.pp.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Let's say thread dies, because of some exception
 * But in that case if we don't have bounded size of queue, producer keep producing which leads to OOM
 */
public class TaskQueue {
    private static final int MAX_SIZE = 25;
    private final Queue<Task> queue;

    public TaskQueue() {
        this.queue = new ArrayDeque<>(MAX_SIZE);
        //this.queue = new ArrayBlockingQueue<>(MAX_SIZE, true);
    }

    public synchronized void push(Task t) {
        if (queue.size() == MAX_SIZE) {
            throw new RuntimeException("Queue overflow");
        }
        this.queue.add(t);
    }

    public synchronized Task pop() {
        return this.queue.remove();
    }


    public synchronized boolean isFull() {
        return this.queue.size() == MAX_SIZE;
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }

}
