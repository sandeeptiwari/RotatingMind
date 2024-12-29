package thread.pp.threadSynchronizers.readWriteLocks;



public class Store {

    private final ReadWriteLock lock;
    private volatile String name;

    public Store(ReadWriteLock lock) {
        this.lock = lock;
        this.name = "tushar";
    }

    public String read() throws InterruptedException {
        try {
            lock.lockRead();
            Thread.sleep(1000);
            printWrite();
            return name;
        }
        finally {
            lock.unlockRead();
        }
    }

    public void write() throws InterruptedException {
        try {
            lock.lockWrite();
            name+="_tushar";
            randomLock();
        }
        finally {
            lock.unlockWrite();
        }
    }

    private void randomLock() throws InterruptedException {
        lock.lockRead();
        lock.unlockRead();
    }


    private void printWrite() throws InterruptedException {
        try{
            lock.lockWrite();
            System.out.println(this.name);
        }
        finally {
            lock.unlockWrite();
        }
    }
}
