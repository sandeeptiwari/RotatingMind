package thread.pp.second;

public class Worker implements Runnable {
    private final NumberStore numberStore;
    private final Object lock;

    public Worker(NumberStore numberStore, Object lock) {
        this.numberStore = numberStore;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            numberStore.increment(lock);
        }
    }
}
