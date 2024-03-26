package thread.pp.server.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);
        WorkerTask w1 = new WorkerTask("A");
        WorkerTask w2 = new WorkerTask("B");
        WorkerTask w3 = new WorkerTask("C");
        WorkerTask w4 = new WorkerTask("D");
        WorkerTask w5 = new WorkerTask("E");
        WorkerTask w6 = new WorkerTask("F");

        executorService.submit(w1);
        executorService.submit(w2);
        executorService.submit(w3);
        executorService.submit(w4);
        executorService.submit(w5);
        Future<?> f6 = executorService.submit(w6);

        executorService.shutdown();
    }
}
