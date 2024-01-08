package thread.pp.latch;

public class CountDownLatch {

    private int count;

    public CountDownLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            System.out.println(Thread.currentThread().threadId()
            + " waiting.");
            wait();
        }

        System.out.println(Thread.currentThread().threadId()
                + " exiting await.");
    }

    public synchronized void countDown() {
        count--;
        if (count == 0) {
            notifyAll();
        }
        System.out.println(Thread.currentThread().threadId()
                + " decreased the count.");
    }
}
