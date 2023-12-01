package thread.pp.sortedjobs.evenoddv1;

public class Main {
    public static final int limit = 20;
    public static int curr = 1;

    /**
     * Now we have multiple even and odd thread
     *
     * @param args
     */
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new EvenWorker("even-1", lock));
        Thread t2 = new Thread(new OddWorker("odd-1", lock));
        Thread t3 = new Thread(new EvenWorker("even-2", lock));
        Thread t4 = new Thread(new OddWorker("odd-2", lock));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
