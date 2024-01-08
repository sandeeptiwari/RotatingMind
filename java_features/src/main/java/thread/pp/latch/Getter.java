package thread.pp.latch;

public class Getter implements Runnable {

    private final OverallSum overallSum;

    private final CountDownLatch countDownLatch;


    public Getter(OverallSum overallSum, CountDownLatch countDownLatch) {
        this.overallSum = overallSum;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("SUM : " + overallSum.getVal());
    }
}
