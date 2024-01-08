package thread.pp.server;

import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class Worker1 implements Runnable {
    private final int id;
    private final BlockingQueue<Task> taskQueue;


    public Worker1(int id, BlockingQueue<Task> taskQueue) {
        this.id = id;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            Task t = null;
            try {
                 t = this.taskQueue.take();
                long curr = System.currentTimeMillis();
                if (curr >= t.getFireTime()) {
                    System.out.println(curr + " | " + t.getFireTime());
                    t.run();
                    if (t.getSubsequentGapInSec() > 0) {
                        t.setFireTime(System.currentTimeMillis() + t.getSubsequentGapInSec() * 1000);
                        taskQueue.put(t);
                    }
                } else {
                    taskQueue.put(t);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
