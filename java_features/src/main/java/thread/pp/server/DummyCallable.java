package thread.pp.server;

import java.util.concurrent.Callable;

public class DummyCallable implements Callable<Integer> {

    private final int k;

    public DummyCallable(int k) {
        this.k = k;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return k;
    }
}
