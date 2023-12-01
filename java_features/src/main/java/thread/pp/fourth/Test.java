package thread.pp.fourth;

public class Test {

    public static void main(String[] args) {
        Number number = new Number();
        //int oldVal = number.getX();
        //number.setX(oldVal + 1);
        Thread t1 = new Thread(new Worker(number));
        Thread t2 = new Thread(new Worker(number));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(number.getX());
    }
}
