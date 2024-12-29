package thread.pp.codingChallenge.multipleEvenOdd;

public class MultiOddWorker implements Runnable {

    private final String type;
    private final Object lock;

    public MultiOddWorker(String type, Object lock) {
        this.type = type;
        this.lock = lock;
    }

    @Override
    public void run() {

        while(compare()){
            synchronized (lock){
                if(MultiEvenOddSimulator.curr > MultiEvenOddSimulator.limit) break;
                if(MultiEvenOddSimulator.curr%2 != 0){
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
