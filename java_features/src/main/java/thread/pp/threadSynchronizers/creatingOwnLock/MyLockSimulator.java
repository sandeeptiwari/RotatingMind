package thread.pp.threadSynchronizers.creatingOwnLock;

public class MyLockSimulator {

    public static void main(String[] args) {

        MyLock myLock = new MyLock();

        Thread t1 = new Thread(new MyLockWorker(myLock));
        Thread t2 = new Thread(new MyLockWorker(myLock));
        Thread t3 = new Thread(new MyLockWorker(myLock));
//        Thread t4 = new Thread(new MaliciousWorker(myLock));

        t1.start();
        t2.start();
        t3.start();
//        t4.start();

    }
}