package thread.pp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class BusyWaiting {
    public static AtomicLong sum = new AtomicLong(0);
    public static AtomicInteger cnt = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            nums.add(random.nextInt());
        }
        long start2 = System.currentTimeMillis();
        seqSum(nums);
        long stop2 = System.currentTimeMillis();

        System.out.println(stop2 - start2);

        long start1 = System.currentTimeMillis();
        concurrentSum(nums);
        long stop1 = System.currentTimeMillis();

        System.out.println(stop1 - start1);
    }

    private static void concurrentSum(List<Integer> nums) {
        int size = nums.size() / 4;
        Thread t1 = new Thread(new Worker(nums, 0, size -1));
        Thread t2 = new Thread(new Worker(nums, size, size -1));
        Thread t3 = new Thread(new Worker(nums, 2*size, size -1));
        Thread t4 = new Thread(new Worker(nums, 3*size, size -1));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        while (cnt.get() < 4) {}
        System.out.println("Sum :: " + sum.get());
    }

    private static void seqSum(List<Integer> nums) {
        long ans = 0;
        for (int i = 0; i < 10000000; i++) {
            ans += nums.get(i);
        }
        System.out.println("Result :: " + ans);
    }


}
