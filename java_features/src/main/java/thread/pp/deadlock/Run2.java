package thread.pp.deadlock;

public class Run2 implements Runnable {

    private final Object lock1, lock2;

    public Run2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        synchronized (lock2) {
            for (int i = 0; i < 10000000; i++) {
                synchronized (lock1) {
                    System.out.println("Hello from Run2");
                }
            }


        }

    }
}
