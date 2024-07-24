package thread.pp.codingChallenge.evenOdd;

public class OddWorker implements Runnable {

    private final String type;
    private final Object lock;

    public OddWorker(String type, Object lock) {
        this.type = type;
        this.lock = lock;
    }

    @Override
    public void run() {

        while(compare()){
            synchronized (lock){
                if(EvenOddSimulator.curr > EvenOddSimulator.limit) break;
                if(EvenOddSimulator.curr%2 != 0){
                    System.out.println(type + " " + EvenOddSimulator.curr);
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
