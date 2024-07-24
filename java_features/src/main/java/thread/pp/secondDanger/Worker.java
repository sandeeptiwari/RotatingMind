package thread.pp.secondDanger;

public class Worker implements Runnable {

    private final int number;
    private final Object lock;
    public Worker(int number, Object lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(compare()){}
        System.out.println(this.number);
        synchronized(lock){
            SortNumbers.x++;
        }
    }

    private boolean compare() {
        synchronized (lock) {
            return this.number != SortNumbers.x;
        }
    }
}

