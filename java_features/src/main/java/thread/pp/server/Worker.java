package thread.pp.server;

import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {
    private final int id;
    private final BlockingQueue<Runnable> taskQueue;

    private final Set<Integer> deadThreads;

    public Worker(int id, BlockingQueue<Runnable> taskQueue, Set<Integer> deadThreads) {
        this.id = id;
        this.taskQueue = taskQueue;
        this.deadThreads = deadThreads;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable task = this.taskQueue.take();
                task.run();
            } catch (Exception e) {
                if ("Shutdown initiated".equals(e.getMessage())) {
                    break;
                }
                synchronized (deadThreads) {
                    System.out.println("Thread " + id + " died");
                    deadThreads.add(id);
                    deadThreads.notifyAll();
                }
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread " + id + " exiting");
    }
}
