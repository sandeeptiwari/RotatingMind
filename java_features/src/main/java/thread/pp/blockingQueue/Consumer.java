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

            /*try {
                //val = q.
            } catch ()*/
        }
    }
}
