package thread.pp.threadSynchronizers.customLocks;

import java.util.concurrent.locks.Lock;

public class CustomLockWorker implements Runnable {

    private final Lock lock1, lock2;
    private final int waitTime;

    public CustomLockWorker(Lock lock1, Lock lock2, int waitTime) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {

        while (true){
            if(lock1.tryLock()){
                try {
                    Thread.sleep(1000);

                    if (lock2.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " Acquired lock!!");
                            return;
                        }
                        finally {
                            lock2.unlock();
                        }
                    }
                }
                 catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock1.unlock();
                }
            }
            else{
                System.out.println(Thread.currentThread().getName() + " Caught in live lock");
            }
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
