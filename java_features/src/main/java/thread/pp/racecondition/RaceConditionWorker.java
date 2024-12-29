package thread.pp.racecondition;

public class RaceConditionWorker implements Runnable {
    private final Number number;

    public RaceConditionWorker(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            number.increment();
        }
    }
}
