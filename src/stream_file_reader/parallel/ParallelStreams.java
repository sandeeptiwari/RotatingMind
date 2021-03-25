package stream_file_reader.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class ParallelStreams {
    /*
     * +
     * ++
     * +++
     * ++++
     * +++++
     * ++++++
     */
    public static void main(String[] args) {
        //not above code will use only 2 pool in fork join
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

        /*Stream.iterate("+", s -> s + "+")
                .parallel()
                .limit(6)
                .peek(s-> System.out.println(s+" processed in the thread "+Thread.currentThread().getName()))
                .forEach(System.out::println);
        */
        //what happen if I will add element into list without/with parallel
        /*
        List<String> list  = new ArrayList<>();
        Stream.iterate("+", s -> s + "+")
                .parallel()//what happen with :: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 823
                .limit(1000)
                //.peek(s-> System.out.println(s+" processed in the thread "+Thread.currentThread().getName()))
                .forEach(ele -> list.add(ele));
        System.out.println("#"+list.size());
         */

        List<String> list  = new CopyOnWriteArrayList<>();
        Stream.iterate("+", s -> s + "+")
                .parallel()//what happen with :: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 823
                .limit(1000)
                //.peek(s-> System.out.println(s+" processed in the thread "+Thread.currentThread().getName()))
                .forEach(ele -> list.add(ele));
        System.out.println("#"+list.size());
    }
}
