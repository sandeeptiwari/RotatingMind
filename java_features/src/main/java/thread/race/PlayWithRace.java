package thread.race;

import java.util.stream.LongStream;

public class PlayWithRace {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Factorials: " + fuctorial(100));

        Thread.currentThread().join();

        System.out.println("Done!");
    }

    /**
     * here state of total object is sharing among more than one thread at a time
     * So it got corrupted very soon.
     *
     * Different threads are running this mul method in parallel on the same object
     * & when we do the total times equal n operation in the mul method.
     *
     * That will end up potentially and almost certainly corrupting the state of the total field,
     * because share and access in multiple thread.
     * @param n
     * @return
     */
    public static long fuctorial(long n) {
        Total total = new Total();
        LongStream.rangeClosed(1, 5)
                .parallel()
                //.peek(System.out::println)
                .forEach(ele -> {
                    total.mul(ele);
                    //System.out.println(total.total);
                });
        return total.total;
    }
}
