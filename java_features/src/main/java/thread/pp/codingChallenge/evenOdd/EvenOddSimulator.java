package thread.pp.codingChallenge.evenOdd;

public class EvenOddSimulator {

    public static int curr = 1;
    public static final int limit = 20;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread oddThread = new Thread(new OddWorker("odd", lock));
        Thread evenThread = new Thread(new EvenWorker("even", lock));

        oddThread.start();
        evenThread.start();
    }
}
