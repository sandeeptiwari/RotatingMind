package thread.pp.secondDanger;

public class SortNumbers {

    public static volatile int x = 1;

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Worker(1, lock));
        Thread t2 = new Thread(new Worker(2,lock ));
        Thread t3 = new Thread(new Worker(3, lock));
        Thread t4 = new Thread(new Worker(4, lock));
        Thread t5 = new Thread(new Worker(5, lock));
        Thread t6 = new Thread(new Worker(6, lock));
        Thread t7 = new Thread(new Worker(7, lock));
        Thread t8 = new Thread(new Worker(8, lock));
        Thread t9 = new Thread(new Worker(9, lock));
        Thread t10 = new Thread(new Worker(10, lock));
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
