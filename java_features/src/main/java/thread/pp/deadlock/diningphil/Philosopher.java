package thread.pp.deadlock.diningphil;


/**
 * Scenario in real world can we happen every Philosopher picked his left chopstick
 * and not started eating yet.
 * In that case they would noty able to eat because there is no right chopstick available
 * since all left chopstick, picked by philosopher.
 *
 * Its kind of cyclic dependency. To solve this problem will assign some sort of id and check greater should get lock fist
 * in chopstick class
 *
 *
 */
public class Philosopher implements Runnable {
    private final Chopstick left, right;
    private final String name;

    public Philosopher(Chopstick left, Chopstick right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name + " is thinking...");

            Chopstick c1, c2;

            if (left.getId() < right.getId()) {
                c1 = left;
                c2 = right;
            } else {
                c1 = right;
                c2 = left;
            }

            try {
                Thread.sleep(2000);
                synchronized (c1) {
                    synchronized (c2) {
                        System.out.println(name + " is eating yum :)... ");
                        Thread.sleep(2000);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
