package thread.pp.blockingQueue;

public class Consumer implements Runnable {

    private final MyBlockingQueue q;

    public Consumer(MyBlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            int val;

            try {
                val = q.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().threadId()
            + " extracted " + val);

            if (val == -1) {
                break;
            }
        }
    }
}
