package stream.designpattern;


public class PlayWithConsumer {

    public static void main(String[] args) {
        PlayWithConsumer playWithConsumer = new PlayWithConsumer();

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = System.out::println;
        Consumer<String> c3 = c1.andThen(null);

        c3.accept("hello");
        //c1.andThen(c2).accept("Hello");
    }
}
