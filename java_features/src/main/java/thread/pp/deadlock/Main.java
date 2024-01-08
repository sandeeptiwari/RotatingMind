package thread.pp.deadlock;

public class Main {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(new Run1(lock1, lock2));
        Thread t2 = new Thread(new Run1(lock1, lock2));

        t1.start();
        t2.start();

    }
}
