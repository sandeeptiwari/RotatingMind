package thread.pp.blockingQueue;

import java.util.Random;

public class Producer implements Runnable {

    private final MyBlockingQueue blockingQueue;
    private final Random random;

    public Producer(MyBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            try {
                int val = random.nextInt(10, 100);
                blockingQueue.put(val);
                System.out.println(Thread.currentThread().threadId() + " inserted " +val );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                blockingQueue.put(-1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
