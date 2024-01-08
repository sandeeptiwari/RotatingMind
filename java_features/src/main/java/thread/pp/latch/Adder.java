package thread.pp.latch;

import java.util.List;

public class Adder implements Runnable {

    private final int s, e;

    private final List<Integer> nums;

    private final CountDownLatch countDownLatch;

    private final OverallSum overallSum;

    public Adder(int s, int e, List<Integer> nums, CountDownLatch countDownLatch, OverallSum overallSum) {
        this.s = s;
        this.e = e;
        this.nums = nums;
        this.countDownLatch = countDownLatch;
        this.overallSum = overallSum;
    }


    @Override
    public void run() {
        int a = 0;

        for (int i = s; i <= e; i++) {
            a += nums.get(i);
        }
        overallSum.add(a);
        countDownLatch.countDown();
    }
}
