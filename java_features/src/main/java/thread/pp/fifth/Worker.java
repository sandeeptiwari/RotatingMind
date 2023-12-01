package thread.pp.fifth;

public class Worker implements Runnable {

    private final NumStore numStore;

    public Worker(NumStore numStore) {
        this.numStore = numStore;
    }

    @Override
    public void run() {
        numStore.incr();
    }
}
