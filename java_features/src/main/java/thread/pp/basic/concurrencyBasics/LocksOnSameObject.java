package thread.pp.basic.concurrencyBasics;

public class LocksOnSameObject {

    public static void main(String[] args) throws InterruptedException {

        NumberStore numberStore = new NumberStore();
        Thread t1 = new Thread(new Worker(numberStore));
        Thread t2 = new Thread(new Worker(numberStore));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(numberStore.getX());
    }
}
