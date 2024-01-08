package thread.pp.server;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Server {

    public FutureTask<Integer> getPairCount(List<Integer> nums, int sum) throws InterruptedException {
        Callable<Integer> callable
                = new PairCounter(nums, sum);
        FutureTask<Integer> futureTask =
                new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        t.join();
        return futureTask;
    }

}
