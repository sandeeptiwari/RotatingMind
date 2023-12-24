package thread.pp.basic;

public class Worker2 implements Runnable{

    public void run() {
       throw new RuntimeException("I am broken");
    }
}
