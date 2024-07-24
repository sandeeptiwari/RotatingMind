package thread.pp.codingChallenge.threeRounds.global;

public class Worker implements Runnable {

    private final int number;
    private final Object lock;

    public Worker(int number, Object lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            while(compare()){}
            synchronized(lock){
                if(SortNumbers3Rounds.rounds == 0) {
                    break;
                }
                System.out.print(this.number + " ");
                SortNumbers3Rounds.x = (SortNumbers3Rounds.x+1)%10;
                if(SortNumbers3Rounds.x == 0) {
                    SortNumbers3Rounds.rounds--;
                    System.out.println();
                }
            }
        }
    }

    private boolean compare() {
        synchronized (lock) {
            return this.number != SortNumbers3Rounds.x && SortNumbers3Rounds.rounds != 0;
        }
    }
}

