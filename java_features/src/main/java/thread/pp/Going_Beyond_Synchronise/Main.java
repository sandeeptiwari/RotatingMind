package thread.pp.Going_Beyond_Synchronise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            /**
             * critical section
             */
        } finally {
            lock.unlock(); // explicitly we must have to unlock
        }

    }
}
