package stream.test;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TestMap {

    public static void main(String[] args) {
        String entries[] = {"Sandeep", "Mahesh", "Suresh", "ramdhan"};
        Class keyType = String.class;
        Class valueType = String.class;

        Map<Object, Object> map = IntStream.range(0, entries.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
        System.out.println(map);

        URI uri = URI.create("https://s3.amazonaws.com/rotating-mind-brainy/post/media/1590641950828-ch1.mp4");
        String protocol = uri.getScheme();
        String server = uri.getAuthority();
        String path = uri.getPath();
    }
}
