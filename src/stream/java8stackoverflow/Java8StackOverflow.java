package stream.java8stackoverflow;

import stream.reducedemo.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://stackoverflow.com/questions/61282943/spring-preauthorize-securitycontext-not-populated-on-parallelstream
 */

public class Java8StackOverflow {

    private List<Employee> load() {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1001, "Sandeep Tiwari", 35, 120000, "600, 100, 890");
        Employee e2 = new Employee(1002, "Diwakar dubey", 50000, 55000, "400, 890, 500");
        Employee e3 = new Employee(1003, "Somil Jain", 32, 10000, "123, 300, 200");
        Employee e4 = new Employee(1004, "Sunil Kummar Sant", 39, 40000, "845, 200, 456");
        Employee e5 = new Employee(1005, "Ramesh Jaintwal", 45, 35000, "567, 890, 100");
        Employee e6 = new Employee(1006, "Khajan Jaintwal", 35, 10000, "100, 567, 900");
        Employee e7 = new Employee(1007, "Deepak Tiwari", 40, 20000, "800, 900, 100");
        Employee e8 = new Employee(1008, "Ramesh Mishra", 65, 10000, "900, 845, 456");
        Employee e9 = new Employee(1009, "Narendra Modi", 70, 15000, "123, 456, 456");
        Employee e10 = new Employee(10010, "Pranav Mukherji", 80, 15000, "123, 567, 678");
        Employee e11 = new Employee(10011, "Lata Mangeshkar", 94, 10000, "123, 456, 700");

        return Arrays.asList(
                e1, e2,
                e3, e4,
                e5, e6,
                e7, e8,
                e9, e10,
                e11
        );
    }


    public static void main(String[] args) {
        Java8StackOverflow obj = new Java8StackOverflow();
        obj.testArraySplit();
    }

    private void mergerAPairOfIntArray() {
        int[] firstArray = new int[] { 10 , 20 , 30 , 40 };
        int[] secondArray = new int[] { 50 , 60 , 70 , 80 };
        /*List<Integer> mergeList =
                Stream.of(firstArray, secondArray)
                        .flatMap(integers -> Arrays.stream(integers))
                        .collect(Collectors.toList());
        System.out.println(mergeList);
         */
        int[] merged = IntStream.concat(IntStream.of(firstArray), IntStream.of(secondArray)).toArray();
        System.out.println(Arrays.toString(merged));


        int[] merged2 = Stream.of(firstArray, secondArray).flatMapToInt(IntStream::of)
                .toArray();
    }

    /**
     * https://stackoverflow.com/questions/57923706/retrieving-list-of-employees-with-lowest-salary-using-stream
     * Retrieving list of employees with lowest salary using stream
     */
    private void retriveAllLowestSalaryFromList() {
        List<Employee> employees = load();
        Function<Employee, Integer> classifier =
                employee -> employee.getSalary();
        //TreeMap<Integer, List<Employee>>
        List<Employee> empsWithLowestSalary = employees.stream()
                .collect(Collectors.groupingBy(classifier, TreeMap::new, Collectors.toList()))
                .firstEntry()
                .getValue();
        //System.out.println(empsWithLowestSalary);


        List<Employee> empsWithLowestSalary2 = employees.stream()
                .collect(minList(Comparator.comparing(Employee::getSalary)));

        System.out.println(empsWithLowestSalary2);

    }

    static <T> Collector<T, ?, List<T>> minList(Comparator<? super T> comp) {
        return Collector.of(ArrayList::new, (list, t) -> {
            int c;
            if (list.isEmpty() || (c = comp.compare(t, list.get(0))) == 0)
                list.add(t);
            else if (c < 0) {
                /*
                 * We have found a smaller element than what we already have. Clear the list and
                 * add this smallest element to it.
                 */
                list.clear();
                list.add(t);
            }
        }, (list1, list2) -> {
            if (comp.compare(list1.get(0), list2.get(0)) < 0)
                return list1;
            else if (comp.compare(list1.get(0), list2.get(0)) > 0)
                return list2;
            else {
                list1.addAll(list2);
                return list1;
            }
        });
    }

    private void testArraySplit() {
        List<Employee> employees = load();

        List<String> allDepartments = employees.stream().map(Employee::getDepartmentId)
                .flatMap(depId -> Arrays.stream(depId.split(", ")))
                //.map(ele -> Integer.parseInt(ele))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(allDepartments);
    }
}
