package thread.pp.sortedjobs.evenodd;

public class Main {
    public static final int limit = 20;
    public static int curr = 1;

    /**
     * Program ran and its Hung, Here curr is something which is shared var across both thread
     * and without any lock thread is mutating the curr, which is memory visibility issue
     * Solu: -
     * public static volatile int curr = 1;
     *
     * But even after changing curr as a volatile output is inconsistent, its printing un-predectable output:
     *
     * It means that we have some race condition in our code:
     *
     * Main.crr++ could not be lead to race condition, because at a time only one thread ont the basis of if (Even|Odd)
     * will mutate the value of Main.curr
     *
     * Then which is the critical section here:
     *
     * if Our code we have 2 check while and if
     * 1- while(Main.curr < Main.limit)
     * 2- if (Main.curr %2 != 0)
     *
     * its kind of compound statement because just after 1st statement context switching might be happened
     *
     * Not lets remove volatile and create one lock here
     *
     * @param args
     */
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new EvenWorker("even", lock));
        Thread t2 = new Thread(new OddWorker("odd", lock));

        t1.start();
        t2.start();
    }
}
