package thread.pp.fizzbuzz;

public class FizzBuzz implements Runnable {

    private final Object lock;

    public FizzBuzz(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (Main.i <= Main.n) {
            synchronized (lock) {
                try {
                    while (!((Main.i % 3 == 0) || (Main.i % 5 == 0))) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Main.i + " FizzBuzz");
                Main.i++;
                lock.notifyAll();
            }
        }
    }
}
