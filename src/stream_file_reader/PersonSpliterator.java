package stream_file_reader;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonSpliterator implements Spliterator<Person> {

    private Spliterator<String> lineSpliterator;
    private String name;
    private int age;
    private String city;

    public PersonSpliterator(Spliterator<String> lineSpliterator) {
        this.lineSpliterator = lineSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action) {
        if (lineSpliterator.tryAdvance(line -> this.name = line) &&
            lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line)) &&
            lineSpliterator.tryAdvance(line -> this.city = line)) {
            Person p = new Person(name, age, city);
            action.accept(p);
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Person> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return lineSpliterator.estimateSize() / 3;
    }

    @Override
    public int characteristics() {
        return lineSpliterator.characteristics();
    }
}
