package thread.pp.fizzbuzz;

public class Main {
    public static final int n = 15;
    public static int i  = 1;

    public static void main(String...args) {
        Object lock = new Object();
        Thread fizz = new Thread(new Fizz(lock));
        Thread buzz = new Thread(new Buzz(lock));

        Thread fizzBuzz = new Thread(new FizzBuzz(lock));
        Thread plain = new Thread(new Plain(lock));


        fizz.start();
        buzz.start();
        fizzBuzz.start();
        plain.start();

    }
}
