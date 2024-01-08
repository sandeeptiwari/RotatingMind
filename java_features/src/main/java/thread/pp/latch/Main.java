package thread.pp.latch;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        OverallSum overallSum = new OverallSum();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            nums.add(i);
        }

        int size = 25;

        Thread g = new Thread(new Getter(overallSum, countDownLatch));

        Thread a1 = new Thread(new Adder(0, size - 1, nums, countDownLatch, overallSum));
        Thread a2 = new Thread(new Adder(size, 2*size - 1, nums, countDownLatch, overallSum));
        Thread a3 = new Thread(new Adder(2*size, 3*size - 1, nums, countDownLatch, overallSum));
        Thread a4 = new Thread(new Adder(3*size, 4* size - 1, nums, countDownLatch, overallSum));

        g.start();

        a1.start();
        a2.start();
        a3.start();
        a4.start();

    }
}
