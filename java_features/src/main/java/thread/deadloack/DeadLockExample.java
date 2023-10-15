package thread.deadloack;

public class DeadLockExample {
    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = "s2";

        Thread t1  = new Thread(() -> {
            synchronized (s1) {
                System.out.println("Thread 1: Locked r1");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (s2) {
                    System.out.println("Thread 1: Locked r1");
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread t2  = new Thread(() -> {
            synchronized (s2) {
                System.out.println("Thread 2: Locked r1");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (s1) {
                    System.out.println("Thread 2: Locked r2");
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }



}
