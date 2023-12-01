package thread.pp.sortedjobs;

public class PrintedSortedNums {
    public static volatile int num = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(1));
        Thread t2 = new Thread(new Worker(2));
        Thread t3 = new Thread(new Worker(3));
        Thread t4 = new Thread(new Worker(4));
        Thread t5 = new Thread(new Worker(5));
        Thread t6 = new Thread(new Worker(6));
        Thread t7 = new Thread(new Worker(7));
        Thread t8 = new Thread(new Worker(8));
        Thread t9 = new Thread(new Worker(9));
        Thread t10 = new Thread(new Worker(10));

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
