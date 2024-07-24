package thread.pp.codingChallenge.threeRounds.localCopy;

public class SortNumbers3Rounds {

    public static int x = 1;

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        int rounds = 3;
        Thread t1 = new Thread(new Worker(1, lock, rounds));
        Thread t2 = new Thread(new Worker(2,lock , rounds));
        Thread t3 = new Thread(new Worker(3, lock, rounds));
        Thread t4 = new Thread(new Worker(4, lock, rounds));
        Thread t5 = new Thread(new Worker(5, lock, rounds));
        Thread t6 = new Thread(new Worker(6, lock, rounds));
        Thread t7 = new Thread(new Worker(7, lock, rounds));
        Thread t8 = new Thread(new Worker(8, lock, rounds));
        Thread t9 = new Thread(new Worker(9, lock, rounds));
        Thread t10 = new Thread(new Worker(10, lock, rounds));

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
