package thread.pp.basic.concurrencyBasics.containerSum;

public class SumWorker implements Runnable{


    private final Container container;
    private final Object lock;

    public SumWorker(Container container, Object lock) {
        this.container = container;
        this.lock = lock;
    }

    @Override
    public void run() {
        int x = 0;
        while(true){
            x = container.pluck();
            if(x == -1) break;
            synchronized(lock){
                ContainerSumSimulator.totalSum+=x;
            }
        }
    }
}
