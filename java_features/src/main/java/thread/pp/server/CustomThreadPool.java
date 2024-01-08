package thread.pp.server;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class CustomThreadPool {
    private final int numThreads;
    private final List<Thread> threads;

    /**
     * Queue should be bounded in nature show that it could not be leads any overflow scenario
     */
    private final BlockingQueue<Task> taskQueue;

    public CustomThreadPool(int numThreads) {
        this.numThreads = numThreads;
        this.taskQueue = new PriorityBlockingQueue<>(10, (t1, t2) -> {
            long diff = t1.getFireTime() - t2.getFireTime();
            int res = 0;
            if (diff > 0) {
                res = 1;
            }
            if (diff < 1) {
                res = -1;
            }
            return res;
        });
        this.threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            Thread t = new Thread(new Worker1(i, taskQueue));
            this.threads.add(t);
        }
        for (Thread thread: threads) {
            thread.start();
        }
    }

    public synchronized void  submit(Task t) throws InterruptedException {
        this.taskQueue.put(t);
    }

}
