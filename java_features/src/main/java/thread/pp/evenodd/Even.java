package thread.pp.evenodd;

public class Even implements Runnable {
    private final Object lock;
    private final int num;
    private final int curr;

    public Even(Object lock, int num, int curr) {
        this.lock = lock;
        this.num = num;
        this.curr = curr;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (Main.num >= 0) {
                while (Main.num % 2 != 0 || Main.curr != 0) {
                    try {
                        System.out.println("waiting1111");
                        lock.wait();
                        System.out.println("waiting2222");
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
