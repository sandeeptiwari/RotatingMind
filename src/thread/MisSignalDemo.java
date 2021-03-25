package thread;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MisSignalDemo {

    public static void main(String args[]) throws InterruptedException {
        MissedSignalExample.example();
    }
}

class MissedSignalExample {

    public static void example() throws InterruptedException {

        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread signaller = new Thread(() -> {
            lock.lock();
            condition.signal();
            System.out.println("Sent signal");
            lock.unlock();
        });

        Thread waiter = new Thread(() -> {
            lock.lock();
            try {
                condition.await();
                System.out.println("Received signal");
            } catch (InterruptedException ie) {
                // handle interruption
            }
            lock.unlock();
        });

        signaller.start();
        signaller.join();

        waiter.start();
        waiter.join();

        System.out.println("Program Exiting.");
    }
}
