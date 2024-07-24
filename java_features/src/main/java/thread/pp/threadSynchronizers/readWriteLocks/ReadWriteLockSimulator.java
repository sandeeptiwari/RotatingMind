package thread.pp.threadSynchronizers.readWriteLocks;

public class ReadWriteLockSimulator {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock lock = new ReadWriteLock();

        Store store = new Store(lock);

        Thread read1 = new Thread(new ReadWorker(store));
//        Thread read2 = new Thread(new ReadWorker(store));
        Thread writer1 = new Thread(new WriterWorker(store));
//        Thread read3 = new Thread(new ReadWorker(store));
//        Thread writer2 = new Thread(new WriterWorker(store));
//        Thread read4 = new Thread(new ReadWorker(store));
//        Thread read5 = new Thread(new ReadWorker(store));

        read1.start();
//        read2.start();
//        read3.start();
        writer1.start();
//        writer2.start();
//        read4.start();
//        read5.start();

//        read1.join();
//        read2.join();
//        read3.join();
//        read4.join();
//        read5.join();
//        writer1.join();
//        System.out.println(store.getName());
    }
}
