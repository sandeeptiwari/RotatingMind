package thread.pp.threadSynchronizers.readWriteLocks;

public class WriterWorker implements Runnable {

    private final Store store;

    public WriterWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            store.write();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
