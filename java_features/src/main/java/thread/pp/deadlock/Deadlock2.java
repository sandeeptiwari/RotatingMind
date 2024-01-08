package thread.pp.deadlock;

public class Deadlock2 {

    public static void main(String[] args) {
        /*Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();*/

        MyLock lock1 = new MyLock(1);
        MyLock lock2 = new MyLock(2);
        MyLock lock3 = new MyLock(3);

        Thread t1 = new Thread(new Run3(lock1, lock2));
        Thread t2 = new Thread(new Run3(lock2, lock3));
        Thread t3 = new Thread(new Run3(lock3, lock1));

        t1.start();
        t2.start();
        t3.start();
    }
}
