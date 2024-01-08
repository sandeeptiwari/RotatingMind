package thread.pp.deadlock;

public class Run3 implements Runnable {
   /* private final Object lock1;
    private final Object lock2;*/

    private final MyLock lock1;
    private final MyLock lock2;

    /*public Run3(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }*/

    public Run3(MyLock lock1, MyLock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        MyLock l1, l2;
        if (lock1.getId() < lock2.getId()) {
            l1 = lock1;
            l2 = lock2;
        } else {
            l1 = lock2;
            l2 = lock1;
        }
        synchronized (l1) {
            for (int i = 0; i < 10000000; i++) {
                synchronized (l2) {
                    System.out.println("Thread is " + Thread.currentThread().getName());
                }
            }
        }
    }
}
