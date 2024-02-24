package thread.pp.sortedNumber;


public class NumberWorker implements Runnable {

    private final Object lock;

    private final int val;

    public NumberWorker(Object lock, int val) {
        this.lock = lock;
        this.val = val;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (val > Main.curr) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(val);
            Main.curr++;
            lock.notifyAll();
        }
        //Exception in thread "Thread-4" java.lang.IllegalMonitorStateException: current thread is not owner
        /*while (val > Main.curr) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //while (compare()) {}

        System.out.println(val);
        Main.curr++;
        lock.notifyAll();*/

       /* synchronized (lock) {
            Main.curr++;
        }*/

    }

    private boolean compare() {
        boolean ans = false;
        synchronized (lock) {
            ans = (val > Main.curr);
        }
        return ans;
    }
}
