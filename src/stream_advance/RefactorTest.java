package stream_advance;

import java.util.List;
import java.util.Optional;

class Message {

}

interface Mapper<T extends Message> {
    Optional<T> createFeature();
}

public class RefactorTest {
    private final List<Mapper<? extends Message>> mappers;

    public RefactorTest(List<Mapper<? extends Message>> mappers) {
        this.mappers = mappers;
    }

    /*private List<Message> mapToFeature() {
        mappers.stream()
                .map(mapper -> mapper.createFeature())
                
                .collect(Optionals.toList());
    }*/

    public static void main(String[] args) {

    }
}
