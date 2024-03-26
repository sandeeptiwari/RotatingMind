package thread.pp.fizzbuzz;

public class Buzz implements Runnable {
    private final Object lock;

    public Buzz(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (Main.i <= Main.n) {
            synchronized (lock) {
                try {
                    while (!((Main.i % 5 == 0) && (Main.i % 3 != 0))) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Main.i + " Buzz");
                Main.i++;
                lock.notifyAll();
            }
        }
    }
}
