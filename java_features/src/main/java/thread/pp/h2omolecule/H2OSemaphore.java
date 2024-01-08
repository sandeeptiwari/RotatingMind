package thread.pp.h2omolecule;

public class H2OSemaphore {

    private int hCount;
    private int oCount;

    private int relO, relH;

    public H2OSemaphore() {
        this.hCount = 2;
        this.oCount = 1;
    }

    public synchronized void acquireH() throws InterruptedException {
        while (hCount == 0) {
            wait();
        }
        hCount--;
    }

    public synchronized void acquireO() throws InterruptedException {
        while (oCount == 0) {
            wait();
        }
        oCount--;
    }

    public synchronized void releaseH() {
        relH++;
        if (relH == 2 && relO == 1) {
            hCount = 2;
            oCount = 1;
            relO = 0;
            relH = 0;
            notifyAll();
        }
    }

    public synchronized void releaseO() {
        relO++;
        if (relH == 2 && relO == 1) {
            hCount = 2;
            oCount = 1;
            relO = 0;
            relH = 0;
            notifyAll();
        }
    }
}
