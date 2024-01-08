package thread.pp.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadPool {
    private final int numThreads;
    private final List<Thread> threads;

    /**
     * Queue should be bounded in nature show that it could not be leads any overflow scenario
     */
    private final BlockingQueue<Runnable> taskQueue;
    //private final Set<Integer> deadThreadIds;
   // private final Thread bookKeeper;
    private boolean isShutDownInitiated;
    private int yetToTerminateCount;

    private final Set<Integer> deadThreads;

    private final Thread bookKeeper;

    public ThreadPool(int numThreads) {
        this.numThreads = numThreads;
        this.deadThreads = new HashSet<>();
        this.taskQueue = new ArrayBlockingQueue<>(10);
        this.threads = new ArrayList<>();
        bookKeeper = new Thread(new BookKeeper(deadThreads, threads, taskQueue));

        for (int i = 0; i < numThreads; i++) {
            Thread t = new Thread(new Worker(i, taskQueue, deadThreads));
            this.threads.add(t);
        }
        for (Thread thread: threads) {
            thread.start();
        }
        bookKeeper.start();
    }

    public synchronized FutureTask<Integer>  submit(Callable<Integer> callable) throws InterruptedException {
        if (isShutDownInitiated) {
            throw new RuntimeException("shuting down");
        }
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        this.taskQueue.put(futureTask);
        return futureTask;
    }

    public synchronized void  submit(Runnable runnable) throws InterruptedException {
        if (isShutDownInitiated) {
            throw new RuntimeException("shutting down");
        }
        this.taskQueue.put(runnable);
    }

    public synchronized void shutDown() throws InterruptedException {
        this.isShutDownInitiated = true;
        for (int i = 0; i < numThreads; i++) {
            taskQueue.put(new Shutter());
        }
    }
}
