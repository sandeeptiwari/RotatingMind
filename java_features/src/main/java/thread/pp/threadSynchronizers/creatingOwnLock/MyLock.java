package thread.pp.threadSynchronizers.creatingOwnLock;

public class MyLock {

    private boolean isLocked;
    private Thread lockedBy;
    private int count;

    public MyLock() {
        this.isLocked = false;
        this.lockedBy = null;
        this.count = 0;
    }

    public synchronized void lock() throws InterruptedException {

        while(isLocked && !Thread.currentThread().equals(lockedBy)){
            System.out.println(Thread.currentThread().getId() + " needs to wait");
            wait();
        }
        isLocked = true;
        count++;
        lockedBy = Thread.currentThread();
        System.out.println(Thread.currentThread().getId() + " : acquired lock");
    }

    public synchronized void unlock(){

        if(!isLocked) throw new RuntimeException("No thread has acquired lock");
        if(!Thread.currentThread().equals(lockedBy)){
            throw new RuntimeException("Locked by: " + lockedBy.getId() + " but invoked by: " +
                    Thread.currentThread().getId());
        }
        count--;
        if(count == 0){
            isLocked = false;
            lockedBy = null;
            notifyAll();
        }
        System.out.println(Thread.currentThread().getId() + " : released lock");
    }
}
