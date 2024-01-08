package thread.pp.semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(new CharPrinter('A', semaphore));
        Thread t2 = new Thread(new CharPrinter('B', semaphore));
        Thread t3 = new Thread(new CharPrinter('C', semaphore));
        Thread t4 = new Thread(new CharPrinter('D', semaphore));
        Thread t5 = new Thread(new CharPrinter('E', semaphore));
        Thread t6 = new Thread(new CharPrinter('F', semaphore));
        Thread t7 = new Thread(new CharPrinter('G', semaphore));
        Thread t8 = new Thread(new CharPrinter('H', semaphore));
        Thread t9 = new Thread(new CharPrinter('I', semaphore));
        Thread t10 = new Thread(new CharPrinter('J', semaphore));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

    }
}
