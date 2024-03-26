package thread.pp.server;

import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

/**
 * This class is responsible to start new thread in case if any running tread got died because of some runtimeexception
 */
public class BookKeeper implements Runnable {
    private final Set<Integer> deadThreads;

    private final List<Thread> threads;

    private final BlockingQueue<Runnable> taskQueue;

    public BookKeeper(Set<Integer> deadThreads, List<Thread> threads, BlockingQueue<Runnable> taskQueue) {
        this.deadThreads = deadThreads;
        this.threads = threads;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (deadThreads) {
                while (deadThreads.isEmpty()) {
                    try {
                        deadThreads.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                for (int id : deadThreads) {
                    Thread t = new Thread(new Worker(id, taskQueue, deadThreads));
                    deadThreads.remove(id);
                    threads.set(id, t);
                    t.start();
                    System.out.println("New Thread " + id + " Born");
                }
            }
        }
    }
}
