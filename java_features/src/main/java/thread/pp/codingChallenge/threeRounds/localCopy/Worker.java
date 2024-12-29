package thread.pp.codingChallenge.threeRounds.localCopy;


public class Worker implements Runnable {

    private final int number;
    private final Object lock;
    private int rounds;

    public Worker(int number, Object lock, int rounds) {
        this.number = number;
        this.lock = lock;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        while(this.rounds > 0){
            while(compare()){}
            System.out.print(this.number + " ");
            synchronized(lock){
                SortNumbers3Rounds.x++;
                if(SortNumbers3Rounds.x == 11) {
                    SortNumbers3Rounds.x = 1;
                    System.out.println();
                }
            }
            this.rounds--;
        }
    }

    private boolean compare() {
        synchronized (lock) {
            return this.number != SortNumbers3Rounds.x;
        }
    }
}

