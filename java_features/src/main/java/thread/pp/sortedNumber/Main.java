package thread.pp.sortedNumber;

public class Main {

    public static int curr = 0;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new NumberWorker(lock, 0));
        Thread t2 = new Thread(new NumberWorker(lock, 1));
        Thread t3 = new Thread(new NumberWorker(lock, 2));
        Thread t4 = new Thread(new NumberWorker(lock, 3));
        Thread t5 = new Thread(new NumberWorker(lock, 4));
        Thread t6 = new Thread(new NumberWorker(lock, 5));
        Thread t7 = new Thread(new NumberWorker(lock, 6));
        Thread t8 = new Thread(new NumberWorker(lock, 7));
        Thread t9 = new Thread(new NumberWorker(lock, 8));
        Thread t10 = new Thread(new NumberWorker(lock, 9));

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
    }
}
