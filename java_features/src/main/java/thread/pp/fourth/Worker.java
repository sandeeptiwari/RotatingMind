package thread.pp.fourth;

public class Worker implements Runnable {
    private final Number number;
    public Worker(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        /**
         * Its compound action means its included more that 1 action
         * both these action independently synchronized but compound
         * action is not synchronized
         * (check and then act) -> compound action
         *
         * If we want to make compound action to be thread safe then we have to make
         * individual action thread safe
         */
        /*int oldVal = number.getX();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        number.setX(oldVal + 1);
        */
        for (int i = 0; i < 1000000; i++) {
            number.increment();
        }

    }
}
