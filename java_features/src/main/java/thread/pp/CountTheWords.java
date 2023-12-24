package thread.pp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CountTheWords {


    public static Map<String, Long> countWordFromFile() throws URISyntaxException {

        List<Stream<String>> fileStreams = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = 1; i < 11; i++) {
            String fileName = "thread/file" + i + ".text";
            Path filePath = Paths.get(ClassLoader.getSystemResource(fileName).toURI());

            try {
                List<String> lines = Files.readAllLines(filePath);
                fileStreams.add(lines.stream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Spliterator<String> spliterator = fileStreams.stream()
                .flatMap(stream -> stream)
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .spliterator();

        Stream<String> wordsStream = StreamSupport.stream(spliterator, true);

        Map<String, Long> collect = wordsStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long endTime = System.currentTimeMillis();

        System.out.println("Total Time :: " + (endTime - startTime));
        return collect;
    }

    public static void main(String[] args) throws URISyntaxException {
        Map<String, Long> stringLongMap = countWordFromFile();

        assert stringLongMap != null;
        stringLongMap.forEach((key, value) ->
                System.out.println(" Key --> " + key +  " | "   + " Value -->" + value)
        );
    }
}
