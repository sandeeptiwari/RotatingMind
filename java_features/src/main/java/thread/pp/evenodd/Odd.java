package thread.pp.evenodd;

public class Odd implements Runnable {
    private final Object lock;
    private final int num;

    public Odd(Object lock, int num, int curr) {
        this.lock = lock;
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (Main.num >= 0) {
                while (Main.num % 2 == 0 || Main.curr != 0) {
                    try {
                        System.out.println("waiting0000");
                        lock.wait();
                        System.out.println("waiting3333");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(Main.num + ", ");
                Main.num--;
                Main.curr = 0;
                lock.notifyAll();
            }
        }
    }
}
