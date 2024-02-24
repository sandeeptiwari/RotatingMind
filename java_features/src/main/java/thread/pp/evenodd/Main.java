package thread.pp.evenodd;

public class Main {

    public static int num = 4 ;
    public static int curr = 0 ;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread even = new Thread(new Even(lock, num, curr));
        Thread odd = new Thread(new Odd(lock, num, curr));
        Thread zero = new Thread(new Zero(lock, num, curr));

        even.start();
        odd.start();
        zero.start();
    }
}
