package thread.pp.barrier;

//action is runnable logic
public class MyBarrier {
    private final int numThreads;

    private int count, exits = 0;
    private final Runnable barrierTask;
    private boolean isReady = true;


    public MyBarrier(int numThreads, Runnable barrierTask) {
        this.numThreads = numThreads;
        this.count = numThreads;
        this.barrierTask = barrierTask;
    }

    public synchronized void await() throws InterruptedException {
            count--;
           while (!isReady) {
               wait();
           }

            while (count > 0) {
                wait();
            }

            barrierTask.run();
            isReady = false;
            //count = numThreads;
            notifyAll();
            exits++;
            if (exits == numThreads) { // reset block
                count = numThreads;
                exits = 0;
                isReady = true;
            }
    }
}
