package com.rotatingmind.java8.collectors;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieController {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Set<Movie> movies = new HashSet<>();

        Stream<String> lines = Files.lines(
                Paths.get(ClassLoader.getSystemResource("movies-mpaa.txt").toURI() )
        );

        lines.forEach(line -> {
            String[] elements = line.split("/");
            String title =
                    elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
            String releaseYear =
                    elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));

            if (releaseYear.contains(",")) {
                // with skip movies with a coma in their title
                return;
            }

            Movie movie = new Movie(title, Integer.valueOf(releaseYear));

            for (int i = 1; i < elements.length; i++) {
                String[] name = elements[i].split(", ");
                String lastName = name[0].trim();
                String firstName = "";
                if (name.length > 1) {
                    firstName = name[1].trim();
                }

                Actor actor = new Actor(lastName, firstName);
                movie.addActor(actor);
            }

            movies.add(movie);
        });

        //# of actors
        long numberOfActors = movies.stream()
                .flatMap(movie -> movie.getActors().stream()) //stream<Actors>
                .distinct()
                .count();
        System.out.println("# of Actors " + numberOfActors);

        // # of actors that played greatest number of movies
        Map.Entry<Actor, Long> mostViewedActor = movies.stream()
                .flatMap(movie -> movie.getActors().stream())
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting())
                )
                .entrySet().stream()//Stream<Map.Entry<Actor, Long>>;
                .max(Map.Entry.comparingByValue())
                .get();

        System.out.println("Most viewed actor : " + mostViewedActor);

        /*
         actor that played in the greatest # of movies during a year
         Solution:
         * Map<releaseYear, Map<Actor, #of movies during that year>>
         */

        Map.Entry<Integer, Map.Entry<Actor, AtomicLong>> integerEntryEntry = movies.stream()
                .collect(
                        Collectors.groupingBy(
                                movie -> movie.getReleaseYear(),
                                Collector.of(
                                        () -> new HashMap<Actor, AtomicLong>(),//supplier
                                        (map, movie) -> {
                                            movie.getActors().forEach(
                                                    actor -> map.computeIfAbsent(actor, a -> new AtomicLong()).incrementAndGet()
                                            );
                                        },//accumulator first param would be first map, and second would be stream value
                                        (map1, map2) -> {
                                            map2.entrySet().forEach(entry2 -> {
                                                map1.merge(entry2.getKey(),
                                                        entry2.getValue(),
                                                        (a11, a12) -> {
                                                            a11.addAndGet(a12.get());
                                                            return a11;
                                                        });
                                            });
                                            return map1;
                                        },//combiner
                                        Collector.Characteristics.IDENTITY_FINISH
                                )
                        )
                )//Map<Integer, HashMap<Actor, AtomicLong>;
                //Map<Integer, Map.Entry<Actor, AtomicLong>>
                .entrySet().stream()
                .collect(
                        Collectors.toMap(
                                entry -> entry.getKey(),
                                entry -> entry.getValue().entrySet().stream()
                                        .max(
                                                Map.Entry.comparingByValue(Comparator.comparing(l -> l.get()))
                                        ).get()
                        )
                ) //Map<Integer, Map.Entry<Actor, AtomicLong>>
                .entrySet().stream()
                .max(
                        Map.Entry.comparingByValue(
                                Comparator.comparing(
                                        entry -> entry.getValue().get()
                                )
                        )
                ).get();

        System.out.println(integerEntryEntry);

    }
}
