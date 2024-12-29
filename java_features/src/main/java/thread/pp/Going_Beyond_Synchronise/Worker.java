package thread.pp.Going_Beyond_Synchronise;

import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {
    private final ReentrantLock l1, l2;
    private final int waitTime;

    public Worker(ReentrantLock l1, ReentrantLock l2, int waitTime) {
        this.l1 = l1;
        this.l2 = l2;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        while (true){
            if(l1.tryLock()){
                try {
                    Thread.sleep(1000); // context switch can happen

                    if (l2.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " Acquired lock!!");
                            return;
                        }
                        finally {
                            l2.unlock();
                        }
                    } else {
                        System.out.println("Encountered a deadlock :( ");
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    l1.unlock();
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
