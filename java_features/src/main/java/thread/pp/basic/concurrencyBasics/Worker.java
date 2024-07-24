package thread.pp.basic.concurrencyBasics;

public class Worker implements Runnable {

    NumberStore numberStore;
    public Worker(NumberStore numberStore){
        this.numberStore = numberStore;
    }

    @Override
    public void run() {

        for(int i = 0;i<100000;i++){
            numberStore.increment();
        }
    }
}
