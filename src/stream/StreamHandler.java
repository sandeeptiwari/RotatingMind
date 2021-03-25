package stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamHandler {

    public static void main(String[] args) {
        StreamHandler handler = new StreamHandler();
        List<Instructor> instructors = new InstructorController().getAll();
        //handler.testMap(instructors);
        //handler.testFlatMap(instructors);
       // handler.testMatch(instructors);

        handler.testAllMatch();
    }

    private void testAllMatch() {
        boolean result = Arrays.asList("Fred", "Finda", "Fish")
                .stream()
                .peek(System.out::println)
                .allMatch(s -> s.startsWith("F"));
        System.out.println("Result "+result);
    }

    private void testMaxElement() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Optional<Integer> max = numbers.stream()
                //.max((a, b) -> a.compareTo(b));
                .max(Integer::compareTo);


        System.out.println(max.get());
    }

    private void testReduceTotal(List<Instructor> instructors) {
        //printing the instructor total years of experience
         int totalYearsOfExp = instructors.stream()
                 .map(instructor -> instructor.getYearsOfExperience())
                 //.reduce(0, (a, b) -> a+b);
                .reduce(0, Integer::sum);

        System.out.println(totalYearsOfExp);
    }
    private void testReduce(List<Instructor> instructors) {
        //printing the instructor who has the highest years of experience
        Optional<Instructor> maxExpInstructor1 = instructors.stream()
                .max(Comparator.comparingInt(Instructor::getYearsOfExperience));

        Optional<Instructor> maxExpInstructor = instructors.stream()
                .reduce((i1, i2) -> i1.getYearsOfExperience() > i2.getYearsOfExperience() ?
                        i1 : i2);

        System.out.println(maxExpInstructor.get());
    }

    /*
     * anyMatch, allMatch, nonMatch
     */
    private void testMatch(List<Instructor> instructors) {
        boolean isStartWithJ = instructors.stream()
                //.flatMap(instructor -> instructor.getCourses().stream()) OR
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .anyMatch(ele -> ele.startsWith("J"));

        System.out.println("Is any word in stream start with J => "+isStartWithJ);

        boolean isAllStartWithJ = instructors.stream()
                //.flatMap(instructor -> instructor.getCourses().stream()) OR
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .filter(ele -> ele.startsWith("J"))
                .allMatch(ele -> ele.startsWith("J"));
        System.out.println("Is All words start with J in Stream => "+isStartWithJ);
    }
    /*
     * Get all the courses which are intructor's offers
     */
    private void testFlatMap(List<Instructor> instructors) {
        List<String> courses = instructors.stream()
                //.flatMap(instructor -> instructor.getCourses().stream()) OR
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(courses);
    }

    private void testMap(List<Instructor> instructors) {
        Predicate<Instructor> p1 = instructor -> instructor.isOnline();
        Predicate<Instructor> p2 = instructor -> instructor.getYearsOfExperience() > 10;
        Map<String, List<String>> instructorsMap = instructors
                .stream()
                .filter(p1.and(p2))
                .collect(Collectors.toMap(Instructor::getName, Instructor::getCourses));
    }
}
