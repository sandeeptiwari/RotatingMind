package stream_file_reader.tomsawyer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {
        try {
            Stream<String> stream1 = Files.lines(Paths.get("src/stream_file_reader/tomsawyer/TomSawyer_01.txt"));

             Stream<String> stream2 = Files.lines(Paths.get("src/stream_file_reader/tomsawyer/TomSawyer_02.txt"));
             Stream<String> stream3 = Files.lines(Paths.get("src/stream_file_reader/tomsawyer/TomSawyer_03.txt"));
             Stream<String> stream4 = Files.lines(Paths.get("src/stream_file_reader/tomsawyer/TomSawyer_04.txt"));

            /*System.out.println("Stream1 :: " + stream1.count());
            System.out.println("Stream2 :: " + stream2.count());
            System.out.println("Stream3 :: " + stream3.count());
            System.out.println("Stream4 :: " + stream4.count()); // illegal exception because count close the stream
             */

            //marge all streams into one stream
            Stream<Stream<String>> streamOfStreams = Stream.of(stream1, stream2, stream3, stream4);
            Stream<String> flattenOfLines = streamOfStreams.flatMap(Function.identity());//stream -> stream

            Function<String, Stream<String>> lineSpliter =
                    line -> Pattern.compile(" ").splitAsStream(line);
            Stream<String> streamOfWords =
                    flattenOfLines.flatMap(lineSpliter)
                    .map(word -> word.toLowerCase())
                    .distinct();
            System.out.println("number of words "+streamOfWords.count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*
1- labmda
        2- Stream API ->
        1- consumer -> accept : nt return any value
        2-> predicate -> test :-> return boolean
        3 -> Fuction >  accept one : return
        4-> Supplier -> get : dont have any return

 */