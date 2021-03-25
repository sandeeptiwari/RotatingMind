package stream.reducedemo;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
//https://stackoverflow.com/questions/24308146/why-is-a-combiner-needed-for-reduce-method-that-converts-type-in-java-8#_=_
//https://stackoverflow.com/questions/55970149/how-does-the-reduce-method-work-in-java-8/55970385
public class ReduceDemo {

    private List<Person> load() {
        List<Person> pList = new ArrayList<>();
        Person p1 = new Person(1001, "Sandeep Tiwari", 35);
        Person p2 = new Person(1002, "Diwakar dubey", 30);
        Person p3 = new Person(1003, "Somil Jain", 32);
        Person p4 = new Person(1004, "Sunil Kummar Sant", 39);
        Person p5 = new Person(1005, "Ramesh Jaintwal", 45);
        Person p6 = new Person(1006, "Khajan Jaintwal", 35);
        Person p7 = new Person(1007, "Deepak Tiwari", 40);
        Person p8 = new Person(1008, "Ramesh Mishra", 65);
        Person p9 = new Person(1009, "Narendra Modi", 70);
        Person p10 = new Person(10010, "Pranav Mukherji", 80);
        Person p11 = new Person(10011, "Lata Mangeshkar", 94);

        return Arrays.asList(
                p1, p2,
                p3, p4,
                p5, p6,
                p7, p8,
                p9, p10,
                p11
        );
    }

    public static void main(String[] args) {
       ReduceDemo reduceDemo = new ReduceDemo();
       reduceDemo.filterListWithoutCreatingNewList();
    }

    /**
     * Similar TO::
     *  <pre>{@code
     *       U result = identity;
     *       for (T element : this stream)
     *      result = accumulator.apply(result, element)
     *       return result;
     *      }</pre>
     */
    private void test1() {
        List<Person> pList = load();
        List<Integer> ages = pList.stream()
                .reduce(new ArrayList<>(),
                        (list, p) -> {
                            list.add(p.getAge());
                            return list;
                        }, (list1, list2) -> list1);
        System.out.println("Ages list "+ages);

        //--------------------------------------------
        //step 1- U result = identity;
    }

    private void test3() {
        String res = Arrays.asList("one", "two","three","four")
                .stream()
                .reduce("",
                        (accumulatedStr, str) -> accumulatedStr + str);  //accumulator

        int length = Arrays.asList("one", "two","three","four")
                .stream()
                .reduce(0,
                        (accumulatedInt, str) -> accumulatedInt + str.length(),                 //accumulator
                        (accumulatedInt, accumulatedInt2) -> accumulatedInt + accumulatedInt2); //combiner

        System.out.println("2=> "+res+" 3=> "+length);
    }

    private void test2() {
        List<Person> pList = load();
        Predicate<Person> p1 = p -> p.getAge() >= 40;

        BiFunction<List<Person>, Predicate<Person>, Map<String, Integer>> nameIdMap
                = (persons, personPredicate) -> {
                Map<String, Integer> map = new HashMap<>();
                persons.forEach(person -> {
                    if(personPredicate.test(person)) {
                        map.put(person.getName(), person.getAge());
                    }
                });

                return map;
        };
        System.out.println("Ages map "+nameIdMap.apply(pList, p1));
    }

    private void test4() {
        String[] arr = {"lorem", "ipsum", "sit", "amet"};
        List<String> strs = Arrays.asList(arr);
        Integer identity = 0;
        BinaryOperator<Integer> combiner =
                (integer, integer2) -> integer + integer2;

        BiFunction<Integer, String, Integer> accumulator
                = (integer, s) -> integer + s.length();

        /*
         * combiner.apply(u, accumulator.apply(identity, t)) == accumulator.apply(u, t)
         */

        int r1 = combiner.apply("lorem".length(), accumulator.apply(identity, "lorem"));
        int r2 =  accumulator.apply("lorem".length(), "lorem");

        System.out.println("Test=> "+(r1 == r2));

        /**
         * Arrays.asList("lorem", "ipsum", "sit", "amet")
         *       .stream()
         *       .mapToInt(String::length)
         *       .sum();
         */
        int result = strs.parallelStream()
                .reduce(0, accumulator, combiner);
        System.out.println("Result => "+result);
    }

    /**
     *
     * The Key Concepts: Identity, Accumulator, and Combiner
     * Stream.reduce() operation : let’s break down the operation’s participant elements into separate blocks.
     * That way, we’ll understand more easily the role that each one plays
     * Identity – an element that is the initial value of the reduction operation and the default result if the
     * stream is empty.
     * itemAccumulator – a function that takes two parameters: a partial result of the reduction operation and the next
     * element of the stream
     * Combiner – a function that takes two parameters: a partial result of the reduction operation and the next
     * element of the stream Combiner – a function used to combine the partial result of the reduction operation when
     * the reduction is parallelized, or when there’s a mismatch between the types of the accumulator arguments and
     * the types of the accumulator implementation
     * When a stream executes in parallel, the Java runtime splits the stream into multiple substreams. In such
     * cases, we need to use a function to combine the results of the substreams into a single one. This is the role
     * of the combiner
     * Case 1 : Combiner works with parallelStream as showed in your example
     *
     * Case 2 : Example accumulator with different type of arguments
     * In this case, we have a stream of User objects, and the types of the accumulator arguments are Integer and User.
     * However, the accumulator implementation is a sum of Integers, so the compiler just can’t infer the type of the
     * user parameter.
     */
    private void test5() {
        List<Person> users = load();

        /**
         *  int computedAges = users.stream().reduce(
         *                 0, (partialAgeResult, user) ->
         *                 partialAgeResult + user.getAge());
         *
         * The method reduce(User, BinaryOperator<User>) in the type Stream<User> is not applicable for the arguments
         * (int, (<no type> partialAgeResult, <no type> user) -> {}) : applicable only if input type == output type
         *
         * We can fix this issue by using a combiner: which is method reference Integer::sum or by using
         * lambda expression (a,b)->a+b
         */
        int computedAges = users.stream()
                .reduce(0,
                        (partialAgeResult, user) -> partialAgeResult + user.getAge(),
                        Integer::sum);

        /**
         * To put it simply, if we use sequential streams and the types of the accumulator arguments and the types of
         * its implementation match, we don’t need to use a combiner.
         */

    }


    private void filterListWithoutCreatingNewList() {
        List<Person> persons = new ArrayList<>(load());
        persons.removeIf(p -> p.getAge() <= 40);
        System.out.println(persons);
    }
}
