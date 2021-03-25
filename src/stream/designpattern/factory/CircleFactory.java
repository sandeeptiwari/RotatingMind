package stream.designpattern.factory;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface CircleFactory extends Supplier<Circle> {

    default Circle newInstance() {
        return get();
    }

    default List<Circle> create5Circle() {
        return IntStream.range(0, 5)
                .mapToObj(ele -> newInstance())
                .collect(Collectors.toList());
    }
}
