package thread.pp.h2omolecule;

import thread.pp.semaphore.Semaphore;

public class Hydrogen implements Runnable {
   private final H2OSemaphore semaphore;

    public Hydrogen(H2OSemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
       // while (true) {
            try {
                semaphore.acquireH();

                System.out.println("H");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.releaseH();
            }
       // }
    }
}
