package thread.pp.barrier;

import java.util.Random;

public class Worker implements Runnable {
    private final MyBarrier barrier;
    private final int s, e;
    private final Random random;
    private final Population population;

    public Worker(MyBarrier barrier, int s, int e, Population population) {
        this.barrier = barrier;
        this.s = s;
        this.e = e;
        this.population = population;
        random = new Random();
    }

    @Override
    public void run() {

        int c = 1;

        while(!population.isDistributionEven()) {
            System.out.println("Attempt # " + c++ + " " + Thread.currentThread().getId() + " starting...");

            for (int i = s; i < e; i++) {
                population.setVal(i, random.nextInt(0, 2));

            }

            try {
                barrier.await();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
