package thread.pp.codingChallenge.multipleEvenOdd;

public class MultiEvenWorker implements Runnable{

    private final Object lock;
    private final String type;

    public MultiEvenWorker(String type, Object lock) {
        this.type = type;
        this.lock = lock;
    }

    @Override
    public void run() {

        while(compare()){
            synchronized (this.lock) {
                if (MultiEvenOddSimulator.curr % 2 == 0) {
                    System.out.println(type + " " + MultiEvenOddSimulator.curr);
                    MultiEvenOddSimulator.curr++;
                }
            }
        }
    }

    private boolean compare() {
        synchronized (lock){
            return MultiEvenOddSimulator.curr <= MultiEvenOddSimulator.limit;
        }
    }
}
