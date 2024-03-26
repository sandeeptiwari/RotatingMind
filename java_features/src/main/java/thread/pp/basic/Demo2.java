package thread.pp.basic;

public class Demo2 {

    public static void main(String[] args) {
        Thread childThread = new Thread(() -> {
            // Code in the child thread
            throw new RuntimeException("Exception in child thread");
        });

        childThread.setUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("Exception caught in thread " + thread.getName() + ": " + exception.getMessage());
        });

        childThread.start();

        System.out.println("Hi I am " + Thread.currentThread().getName());
    }
}
