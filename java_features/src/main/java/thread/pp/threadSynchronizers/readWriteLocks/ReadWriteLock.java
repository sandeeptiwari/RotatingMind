package thread.pp.threadSynchronizers.readWriteLocks;

import java.util.HashMap;
import java.util.Map;

// only limitation when multiple read threads is when going for upgradation from read to write reentrancy, it will lead to deadlock.
// To handle this we would first need to relinquish all read locks then call for write locks

public class ReadWriteLock {

    private int writeReq; // to give priority to write requests, all pending reads would be served, new reads will wait
    private final Map<Thread, Integer> entryCounts;
    private final Map<Thread, Integer> writeCounts;

    public ReadWriteLock() {
        this.writeReq = 0;
        this.entryCounts = new HashMap<>();
        this.writeCounts = new HashMap<>();
    }

    public synchronized void lockRead() throws InterruptedException {

        while(!isReadAllowed()){
            System.out.println(Thread.currentThread().getName() + " waiting to acquire read lock");
            wait();
        }
        int cnt = entryCounts.getOrDefault(Thread.currentThread(), 0);

        entryCounts.put(Thread.currentThread(), cnt+1);
        System.out.println(Thread.currentThread().getName() + " acquired read lock");
    }

    private boolean isReadAllowed() {

        if(writeCounts.size() == 1 && writeCounts.get(Thread.currentThread()) != null) return true; // to handle write to read reentrancy(downgrading)

        if(!writeCounts.isEmpty()) return false;
        if(entryCounts.containsKey(Thread.currentThread())) return true;
        if(writeReq > 0) return false;
        return true;
    }

    public synchronized void unlockRead(){

        if(!entryCounts.containsKey(Thread.currentThread())){
            throw new RuntimeException(Thread.currentThread().getName() + " has not acquired read lock");
        }
        int cnt = entryCounts.get(Thread.currentThread());

        if(cnt > 1){
            entryCounts.put(Thread.currentThread(), cnt-1);
        }
        else{
            entryCounts.remove(Thread.currentThread());
            notifyAll();
            System.out.println(Thread.currentThread().getName() + " released read lock");
        }
    }

    public synchronized void lockWrite() throws InterruptedException {
        writeReq++;
        while(!isWriteAllowed()){
            System.out.println(Thread.currentThread().getName() + " waiting to acquire write lock");
            wait();
        }
        writeReq--;
        int cnt = writeCounts.getOrDefault(Thread.currentThread(), 0);
        writeCounts.put(Thread.currentThread(), cnt+1);
        System.out.println(Thread.currentThread().getName() + " acquired write lock");
    }

    private boolean isWriteAllowed() {
        if(entryCounts.size() == 1 && entryCounts.get(Thread.currentThread()) != null) return true; // to handle read to write reentrancy(upgrading)

        if(!entryCounts.isEmpty()) return false;
        if(writeCounts.containsKey(Thread.currentThread())) return true;
        if(!writeCounts.isEmpty()) return false;
        return true;
    }

    public synchronized void unlockWrite(){
        if(!writeCounts.containsKey(Thread.currentThread())){
            throw new RuntimeException(Thread.currentThread().getName() + " has not acquired write lock");
        }
        int cnt = writeCounts.get(Thread.currentThread());

        if(cnt > 1){
            writeCounts.put(Thread.currentThread(), cnt-1);
        }
        else{
            writeCounts.remove(Thread.currentThread());
            notifyAll();
            System.out.println(Thread.currentThread().getName() + " released write lock");
        }

    }
}
