package thread.pp.server;

public class Shutter implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("Shutdown initiated");
    }
}
