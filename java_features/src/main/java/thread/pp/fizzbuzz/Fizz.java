package thread.pp.fizzbuzz;

public class Fizz implements Runnable {

    private final Object lock;

    public Fizz(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (Main.i <= Main.n) {
            synchronized (lock) {
                try {
                    while (!((Main.i % 3 == 0) && (Main.i % 5 != 0))) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Main.i + " Fizz");
                Main.i++;
                lock.notifyAll();
            }
        }

    }
}
