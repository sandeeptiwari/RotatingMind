package thread.pp.sortedjobs.v2;

public class Worker implements Runnable {
    private final int value;
    private final Object lock;

    private int round;

    public Worker(int value, Object lock, int round) {
        this.value = value;
        this.lock = lock;
        this.round = round;
    }


    /**
     *  Just stuck after 1 iterdation:
     *  Here one thread T1 which acquire the lock l1
     *  T1 (1) -> if (1 == 1) l1
     *
     *  Lets say some other thread got scheduled say Thread  T5 whose value is 5, not it enters and got value is 5 which is greater than
     *  PrintedSortedNums.num current value which is 2.
     *
     *  Then condition would be true and loop went infinite. and also it acquired the lock as well and never ever released it.
     *  So No other thread can enter in that sync block.
     */
  /*
   issue methids
  @Override
    public void run() {
        synchronized (lock) {
            while (value > PrintedSortedNums.num) {
            }
        }

        System.out.println(PrintedSortedNums.num);
        synchronized (lock) {
            PrintedSortedNums.num++;
        }
    }*/


    /**
     * fix version
     */
    @Override
    public void run() {
        while (round > 0) {
            while (compare()) {}

            System.out.println(value);

            synchronized (lock) {
                PrintedSortedNums.num = (PrintedSortedNums.num + 1)  % 10;
            }
            round--;
        }
    }

    private boolean compare() {
        boolean ans = false;
        synchronized (lock) {
            ans = !(value == PrintedSortedNums.num);
        }
        return  ans;
    }
}
