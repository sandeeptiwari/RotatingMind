package thread.pp.Going_Beyond_Synchronise;


import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {

    public static void main(String[] args) {
        ReentrantLock l1 = new ReentrantLock();
        ReentrantLock l2 = new ReentrantLock();

        Thread t1 = new Thread(new Worker(l1, l2, 1000));
        Thread t2 = new Thread(new Worker(l2, l2, 2000));

        t1.start();
        t2.start();

    }
}
