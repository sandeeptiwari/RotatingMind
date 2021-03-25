package stream_file_reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingSpliterator {

    public static void main(String[] args) {
        Path path = Paths.get("src/stream_file_reader/person.txt");
        try(Stream<String> lines = Files.lines(path);) {
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);
            Stream<Person> peoples = StreamSupport.stream(peopleSpliterator, false);
            //peoples.forEach(System.out::println);
            /*
             * .parallel wo t work with below code because Arraylist doesnt support
             * concurrency, in result of that it will generate data inconsistency
             */
            ArrayList<Integer> reduce = peoples.reduce(new ArrayList<Integer>(),
                    (list, p) -> {
                        list.add(p.getAge());
                        return list;
                    },
                    (list1, list2) -> list1);
            System.out.println(reduce);
          /*
            * While in other hand below code will work with parallel, because Collectors.toList
            * will handle parallelism and thread-safety for us
           */
            List<Integer> ageList = peoples.parallel()
                    .map(people -> people.getAge())
                    .collect(Collectors.toList());
            System.out.println("Parallel Version:: "+ageList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
