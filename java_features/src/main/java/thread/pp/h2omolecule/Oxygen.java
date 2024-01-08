package thread.pp.h2omolecule;

import thread.pp.semaphore.Semaphore;

public class Oxygen implements Runnable {

    private final H2OSemaphore semaphore;

    public Oxygen(H2OSemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        //while (true) {
            try {
                semaphore.acquireO();
                System.out.println("O");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.releaseO();
            }
        //}
    }
}
