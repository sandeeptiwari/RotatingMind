package thread.pp.evenodd;

public class Zero implements Runnable {

    private final Object lock;
    private final int num;
    private final int curr;

    public Zero(Object lock, int num, int curr) {
        this.lock = lock;
        this.num = num;
        this.curr = curr;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (Main.num >= 0) {
                while (Main.curr != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("0, ");
                Main.curr = 1;
                lock.notifyAll();
            }
        }
    }
}
