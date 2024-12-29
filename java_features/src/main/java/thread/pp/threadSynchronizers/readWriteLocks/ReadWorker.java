package thread.pp.threadSynchronizers.readWriteLocks;

public class ReadWorker implements Runnable {

    private final Store store;
    public ReadWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        String name = null;
        try {
            name = store.read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
