package thread.pp.codingChallenge.evenOdd;

public class EvenWorker implements Runnable{

    private final Object lock;
    private final String type;

    public EvenWorker(String type, Object lock) {
        this.type = type;
        this.lock = lock;
    }

    @Override
    public void run() {

        while(compare()){
            synchronized (this.lock) {
                if (EvenOddSimulator.curr % 2 == 0) {
                    System.out.println(type + " " +EvenOddSimulator.curr);
                    EvenOddSimulator.curr++;
                }
            }
        }
    }

    private boolean compare() {
        synchronized (lock){
            return EvenOddSimulator.curr <= EvenOddSimulator.limit;
        }
    }
}
