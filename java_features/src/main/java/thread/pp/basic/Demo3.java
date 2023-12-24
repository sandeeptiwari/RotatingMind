package thread.pp.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo3 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> l = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000000; i++) {
            l.add(r.nextInt(100, 200));
        }

        int val = 125;
        int numThread = 10;
        int segSize = 10000000 / numThread;

        Number result = new Number(0);

        Thread t1 = new Thread(new Worker3(l, 0, segSize - 1, val, result));

        Thread t2 = new Thread(new Worker3(l, segSize, 2 * segSize - 1, val, result));

        Thread t3 = new Thread(new Worker3(l, 2 * segSize, 3 * segSize - 1, val, result));

        Thread t4 = new Thread(new Worker3(l, 3 * segSize, 4 * segSize - 1, val, result));

        Thread t5 = new Thread(new Worker3(l, 4 * segSize, 5 * segSize - 1, val, result));

        Thread t6 = new Thread(new Worker3(l, 5 * segSize, 6 * segSize - 1, val, result));

        Thread t7 = new Thread(new Worker3(l, 6 * segSize, 7 * segSize - 1, val, result));

        Thread t8 = new Thread(new Worker3(l, 7 * segSize, 8 * segSize - 1, val, result));

        Thread t9 = new Thread(new Worker3(l, 8 * segSize, 9 * segSize - 1, val, result));

        Thread t10 = new Thread(new Worker3(l, 9 * segSize, 10 * segSize - 1, val, result));


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
        t10.join();

     System.out.println(result.getX());
    }
    // [0... segSize-1] [segSize... 2*segSize-1]...
}
