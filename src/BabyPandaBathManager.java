import java.util.concurrent.*;
import java.util.stream.IntStream;

public class BabyPandaBathManager {

    public static void await(CyclicBarrier cb){
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String...args){
        final CyclicBarrier  barrier = new CyclicBarrier(3, ()->System.out.println("Clean!"));
        ExecutorService service = Executors.newScheduledThreadPool(3);
        IntStream.iterate(1, i-> 2)
                .limit(12)
                .forEach(i -> service.submit(() -> await(barrier)));
        service.shutdown();
    }
}
