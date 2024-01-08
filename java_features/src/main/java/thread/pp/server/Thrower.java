package thread.pp.server;

public class Thrower implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("I am always throw");
    }
}
