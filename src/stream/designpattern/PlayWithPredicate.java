package stream.designpattern;

import java.util.stream.Stream;

public class PlayWithPredicate {

    public static void main(String[] args) {
        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = (s) -> s.startsWith("S");

        System.out.println(p1.and(p2).test("Sandi"));
    }
}
