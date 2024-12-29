package thread.pp.threadSynchronizers.customLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomLockSimulator {

    public static void main(String[] args) {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(new CustomLockWorker(lock1, lock2, 1000));
        Thread t2 = new Thread(new CustomLockWorker(lock2, lock1, 2000));

        t1.start();
        t2.start();
    }
}
