package thread.pp.codingChallenge.multipleEvenOdd;

public class MultiEvenOddSimulator {

    public static int curr = 1;
    public static final int limit = 20;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new MultiOddWorker("odd-1", lock));
        Thread t2 = new Thread(new MultiOddWorker("odd-2", lock));
        Thread t3 = new Thread(new MultiEvenWorker("even-1", lock));
        Thread t4 = new Thread(new MultiEvenWorker("even-2", lock));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
