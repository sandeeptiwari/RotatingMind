package thread.pp.fizzbuzz;

public class Plain implements Runnable {
    private final Object lock;

    public Plain(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (Main.i <= Main.n) {
            synchronized (lock) {
                try {
                    while (!((Main.i % 3 != 0) && (Main.i % 5 != 0))) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Main.i + " Plain");
                Main.i++;
                lock.notifyAll();
            }
        }
    }
}
