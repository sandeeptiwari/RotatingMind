package thread.pp.deadlock.banking_problem;

public class Bank {

    /**
     * If we make this method synchronized in that case things will work because once one thread will enter this method
     * other thread wont allow to enter this method, because it will work as a critical section
     *
     * Problem:All thread is kind of wait here in bank class because this is bottle neck
     *
     * @param source
     * @param destination
     * @param amount
     */
    public synchronized void transfer(Account source, Account destination, int amount) {
        source.deduct(amount);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        destination.add(amount);
    }
}
